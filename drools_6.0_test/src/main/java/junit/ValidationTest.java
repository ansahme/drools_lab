package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.command.Command;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

import bank.model.Customer;
import bank.service.BankingInquiryService;
import bank.service.impl.BankingInquiryServiceImpl;
import bank.validation.Message;
import bank.validation.ReportFactory;
import bank.validation.ValidationReport;
import bank.validation.impl.DefaultReportFactory;

public class ValidationTest {
	static KieServices kServices = KieServices.Factory.get();
	//static KieContainer kc = kServices.getKieClasspathContainer();
	//static StatelessKieSession ksession = kc.newStatelessKieSession();
	
	static KieModuleModel kModuleModel = kServices.newKieModuleModel();
	
	static KieFileSystem kFileSystem = kServices.newKieFileSystem();
	 static StatelessKieSession session;
	
	static ReportFactory reportFactory;
	
	@BeforeClass
	public static void setupClass() throws Exception {
//		KieBaseModel kieBaseModel = kModuleModel.newKieBaseModel("KBase1")
//				.setDefault(true)
//				.setEqualsBehavior(EqualityBehaviorOption.EQUALITY)
//				.setEventProcessingMode(EventProcessingOption.STREAM);
//		
		
		//??
		//KieBaseConfiguration configuration = kServices.newKieBaseConfiguration();
		//configuration.setOption(SequentialOption.YES);
		
		kFileSystem.write(kServices.getResources()
				.newFileSystemResource("src/main/java/bank/validation/validation.drl")
				.setResourceType(ResourceType.DRL));

		KieBuilder builder = kServices.newKieBuilder(kFileSystem).buildAll();
		
		KieContainer kieContainer = kServices.newKieContainer(kServices.getRepository().getDefaultReleaseId());
		
		//Create knowledge base
		
//		KieBase kBase = kieContainer.newKieBase(configuration);
//		 session = kBase.newStatelessKieSession();
		
		KieBase kBase = kieContainer.getKieBase();
		 session = kBase.newStatelessKieSession();
				
		//whuey why?
		assertEquals(0,builder.getResults().getMessages(org.kie.api.builder.Message.Level.ERROR).size());
		//if(builder.hasErrors()){
			//throw new RuntimeException(builder.getErrors().toString());
		//}
		
		BankingInquiryService inquiryService = new BankingInquiryServiceImpl();
		reportFactory = new DefaultReportFactory();
		
		session.setGlobal("reportFactory", reportFactory);
		session.setGlobal("inquiryService", inquiryService);
	}

//	private static void assertEquals(int i, int size) {
//		// TODO Auto-generated method stub
//		System.out.println(i == size);
//	}
	
	@Test
	public void addressRequired() throws Exception {
		Customer customer = createCustomerBasic();
		assertNull(customer.getAddress());
		assertReportContains(Message.Type.WARNING, "addressRequired", customer);
	}

	private void assertReportContains(Message.Type type, String messageKey,
			Customer customer, Object... context) {
		ValidationReport report = reportFactory.createValidationReport();
		List<Command> commands = new ArrayList<Command>();
		commands.add(CommandFactory.newSetGlobal("validationReport", report));
		commands.add(CommandFactory.newInsertElements(getFacts(customer)));
		session.execute(CommandFactory.newBatchExecution(commands));
		
		Assert.assertTrue("Report doesn't contain message [" + messageKey + "]", report.contains(messageKey));
		Message message = getMessage(report, messageKey);
		
		assertEquals(Arrays.asList(context), message.getContextOrdered());
	}

	private Message getMessage(ValidationReport report, String messageKey) {
		for(Message msg : report.getMessages()){
			if(msg.getMesageKey().equalsIgnoreCase(messageKey)){
				return msg;
			}
		}
		return null;
	}

	private Collection<Object> getFacts(Customer customer) {
		ArrayList<Object> facts = new ArrayList<Object>();
		facts.add(customer);
		facts.add(customer.getAddress());
		facts.add(customer.getAccounts());
		return facts;
	}

	private Customer createCustomerBasic() {
		Customer customer = new Customer();
		
		return customer;
	}

}
