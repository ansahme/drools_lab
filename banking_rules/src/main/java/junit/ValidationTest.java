package junit;

import org.drools.core.marshalling.impl.ProtobufMessages.KnowledgeBase;
import org.junit.BeforeClass;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.io.ResourceFactory;
import org.kie.api.builder.*;

import validation.ReportFactory;

public class ValidationTest {
	static KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
	static StatelessKieSession ksession = kc.newStatelessKieSession();
	static ReportFactory reportFactory;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		KieBuilder builder = kc.newKi.add(ResourceFactory.newClassPathResource("validation.drl"), ResourceType.DRL);
		if(builder.hasErrors()){
			throw new RuntimeException(builder.getErrors().toString());
		}
		KieBaseConfiguration configuration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase(configuration);
	}

}
