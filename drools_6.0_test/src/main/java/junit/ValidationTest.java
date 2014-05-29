package junit;

import org.drools.core.marshalling.impl.ProtobufMessages.KnowledgeBase;
import org.junit.BeforeClass;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.conf.EqualityBehaviorOption;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.conf.SequentialOption;
import org.kie.internal.io.ResourceFactory;

import bank.validation.ReportFactory;

public class ValidationTest {
	static KieServices kServices = KieServices.Factory.get();
	static KieContainer kc = kServices.getKieClasspathContainer();
	static StatelessKieSession ksession = kc.newStatelessKieSession();
	
	static KieModuleModel kModuleModel = kServices.newKieModuleModel();
	
	static KieFileSystem kFileSystem = kServices.newKieFileSystem();
	
	
	static ReportFactory reportFactory;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		KieBaseModel kieBaseModel = kModuleModel.newKieBaseModel("KBase1")
				.setDefault(true)
				.setEqualsBehavior(EqualityBehaviorOption.EQUALITY)
				.setEventProcessingMode(EventProcessingOption.STREAM);
		
		//??
		KieBaseConfiguration configuration = kServices.newKieBaseConfiguration();
		configuration.setOption(SequentialOption.YES);
		
		kFileSystem.write(kServices.getResources()
				.newFileSystemResource("src/main/java/bank/validation/validation.drl")
				.setResourceType(ResourceType.DRL));

		KieBuilder builder = kServices.newKieBuilder(kFileSystem).buildAll();
		
		//if(builder.hasErrors()){
			//throw new RuntimeException(builder.getErrors().toString());
		//}
		
	}

}
