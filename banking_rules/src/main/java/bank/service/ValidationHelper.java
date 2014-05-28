package bank.service;

import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.rule.RuleContext;

import validation.Message;
import validation.ReportFactory;
import validation.ValidationReport;

public class ValidationHelper {
	/**
	 * Adds an error message to the global validation report
	 * @param kcontext RuleContext that is accessible from rule condition.
	 * @param context for the message
	 */
	
	public static void error(RuleContext kcontext, Object... context){
		KieRuntime knowledgeRuntime = kcontext.getKieRuntime();
		ValidationReport validationReport = (ValidationReport)knowledgeRuntime.getGlobal("validationReport");
		ReportFactory reportFactory = (ReportFactory)knowledgeRuntime.getGlobal("reportFactory");
		
		validationReport.addMessage(reportFactory.createMessage(Message.Type.ERROR, kcontext.getRule().getName(), context));
	}
	
	public static void warning(RuleContext kcontext, Object... context){
		KieRuntime knowledgeRuntime = kcontext.getKieRuntime();
		ValidationReport validationReport = (ValidationReport)knowledgeRuntime.getGlobal("validationReport");
		ReportFactory reportFactory = (ReportFactory)knowledgeRuntime.getGlobal("reportFactory");
		
		validationReport.addMessage(reportFactory.createMessage(Message.Type.WARNING, kcontext.getRule().getName(), context));
	}

}
