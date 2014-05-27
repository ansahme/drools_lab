package bank.service;

import org.drools.runtime.KnowledgeRuntime;
import org.drools.runtime.rule.RuleContext;

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
		KnowledgeRuntime knowledgeRuntime = kcontext.getKnowledgeRuntime();
		ValidationReport validationReport = (ValidationReport)knowledgeRuntime.getGlobal("validationReport");
		ReportFactory reportFactory = (ReportFactory)knowledgeRuntime.getGlobal("reportFactory");
		
		validationReport.addMessage(reportFactory.createMessage(Message.Type.ERROR, kcontext.getRule().getName(), context));
	}
	
	public static void warning(RuleContext kcontext, Object... context){
		KnowledgeRuntime knowledgeRuntime = kcontext.getKnowledgeRuntime();
		ValidationReport validationReport = (ValidationReport)knowledgeRuntime.getGlobal("validationReport");
		ReportFactory reportFactory = (ReportFactory)knowledgeRuntime.getGlobal("reportFactory");
		
		validationReport.addMessage(reportFactory.createMessage(Message.Type.WARNING, kcontext.getRule().getName(), context));
	}

}
