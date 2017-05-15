package org.vaadin.felype.ui.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.felype.ui.ValueLabel;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("ValueLabel Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

	public class MyBean {
		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	private int valueInLabel = 0;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
	public static class Servlet extends VaadinServlet {
	}

	private int value = 1;

	@Override
	protected void init(VaadinRequest request) {
		ValueLabel valueLabel = new ValueLabel(String.valueOf(value));
		valueLabel.addValueChangeListener(event -> Notification.show("Value Changed"));

		Button btnChangeValue = new Button("Change value", event -> valueLabel.setValue(String.valueOf(++value)));

		setContent(new VerticalLayout(valueLabel, btnChangeValue));
	}
}
