package de.herrmann.lowcode.irishmusic.rules;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlScript;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.introspection.JexlPermissions;
import org.springframework.stereotype.Component;

@Component
public class JexlRules {

	private final EventPlanningRules eventPlanningRules;
	
	public JexlRules(EventPlanningRules eventPlanningRules) {
		this.eventPlanningRules = eventPlanningRules;
	}
	
	public Object evaluateExpression(String expression) {
		
		JexlEngine engine = new JexlBuilder().permissions(JexlPermissions.UNRESTRICTED).safe(false).create();
		JexlScript script = engine.createScript(expression);
		return script.execute(createJexlContext());
	}
	
	private JexlContext createJexlContext() {
		JexlContext context = new MapContext();
		context.set("eventPlanning", eventPlanningRules);
		return context;
	}
}
