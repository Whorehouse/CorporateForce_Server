package org.corporateforce.server.helper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TextLabels {

	private static final Map<String, String> LABELS;
	static {
		HashMap<String, String> labelsTemp = new HashMap<String, String>();
		// text
		labelsTemp.put("header_sign_in", "Вход в систему");
		labelsTemp.put("header_sign_up", "Регистрация в системе");
		//errors
		labelsTemp.put("error_empty_fields", "Не все поля заполнены");
		labelsTemp.put("error_username_or_password", "Неверное имя пользователя или пароль");
		LABELS = Collections.unmodifiableMap(labelsTemp);
	}

	public static String getTextLabel(String ident) {
		String result = LABELS.get(ident);
		return result != null ? result : ident;
	}
}
