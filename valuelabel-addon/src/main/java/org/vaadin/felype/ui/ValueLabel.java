package org.vaadin.felype.ui;

import com.vaadin.data.HasValue;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;

public class ValueLabel extends Label implements HasValue<String> {

	private static final long serialVersionUID = -5356716417533453348L;

	public ValueLabel() {
		this("");
	}

	public ValueLabel(String text) {
		this(text, ContentMode.TEXT);
	}

	public ValueLabel(String text, ContentMode contentMode) {
		setValue(text);
		setContentMode(contentMode);
	}

	@Override
	public Registration addValueChangeListener(ValueChangeListener<String> listener) {
		return addListener(ValueChangeEvent.class, listener, ValueChangeListener.VALUE_CHANGE_METHOD);
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		super.setReadOnly(readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return super.isReadOnly();
	}

	@Override
	public boolean isRequiredIndicatorVisible() {
		return super.isRequiredIndicatorVisible();
	}

	@Override
	public void setRequiredIndicatorVisible(boolean visible) {
		super.setRequiredIndicatorVisible(visible);
	}

	@Override
	public void setValue(String value) {
		String oldValue = getValue();

		super.setValue(value);

		fireEvent(new ValueChangeEvent<String>(this, oldValue, false));
	}
}
