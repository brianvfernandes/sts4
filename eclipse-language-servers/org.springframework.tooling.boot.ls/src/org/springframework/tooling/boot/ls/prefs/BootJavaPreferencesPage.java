/*******************************************************************************
 * Copyright (c) 2017, 2024 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.tooling.boot.ls.prefs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.springframework.tooling.boot.ls.BootLanguageServerPlugin;
import org.springframework.tooling.boot.ls.Constants;

/**
 * Preference page for Boot-Java LS extension
 * 
 * @author Alex Boyko
 *
 */
public class BootJavaPreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(BootLanguageServerPlugin.getDefault().getPreferenceStore());
	}
	
	@Override
	protected void createFieldEditors() {
		Composite fieldEditorParent = getFieldEditorParent();
		
		addField(new BooleanFieldEditor(Constants.PREF_START_LS_EARLY, "Start Language Server at startup if Spring Boot is a dependency", fieldEditorParent));
		addField(new BooleanFieldEditor(Constants.PREF_SCAN_JAVA_TEST_SOURCES, "Scan Java test sources", fieldEditorParent));
		
		addField(new BooleanFieldEditor(Constants.PREF_CHANGE_DETECTION, "Live Boot Change Detection", fieldEditorParent));

		// Experimental Modulith support
		addField(new BooleanFieldEditor(Constants.PREF_MODULITH, "Spring Boot Modulith automatic project tracking and metadata update", fieldEditorParent));
		
		Composite c = new Composite(fieldEditorParent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(c);
		FileFieldEditor propMetadataFileEditor = new FileFieldEditor(Constants.PREF_COMMON_PROPS_METADATA, "Shared Properties", true, c);
		propMetadataFileEditor.setFileExtensions(new String[] {"json"});
		addField(propMetadataFileEditor);
		
	}

}
