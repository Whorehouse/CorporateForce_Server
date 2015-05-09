package org.corporateforce.server.controller;

import org.corporateforce.server.helper.TextLabels;

public abstract class AbstractController {
	
	public String getTextLabel(String ident) {
		return TextLabels.getTextLabel(ident);
	}
}
