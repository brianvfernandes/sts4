/*******************************************************************************
 * Copyright (c) 2022, 2024 VMware, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     VMware, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.vscode.commons.java;

import java.net.URI;

import org.springframework.ide.vscode.commons.protocol.java.Gav;

public interface IProjectBuild {
	
	String getType();
	
	URI getBuildFile();
	
	IGav getGav();
		
	static IProjectBuild create(String type, URI buildFile, Gav gav) {
		return new IProjectBuild() {
			
			@Override
			public String getType() {
				return type;
			}
			
			@Override
			public URI getBuildFile() {
				return buildFile;
			}
			
			public IGav getGav() {
				return IGav.create(gav);
			}
		};
	}

}
