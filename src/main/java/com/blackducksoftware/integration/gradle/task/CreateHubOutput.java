/*******************************************************************************
 * Black Duck Software Suite SDK
 * Copyright (C) 2016 Black Duck Software, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 *******************************************************************************/
package com.blackducksoftware.integration.gradle.task;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import com.blackducksoftware.integration.gradle.DependencyGatherer;
import com.blackducksoftware.integration.gradle.PluginHelper;

public class CreateHubOutput extends DefaultTask {
	private PluginHelper pluginHelper;
	private String outputDirectory;

	@TaskAction
	public void gatherDependencies() throws IOException {
		final Project project = getProject();
		File output = pluginHelper.getBlackDuckDirectory();
		if (StringUtils.isNotBlank(outputDirectory)) {
			output = new File(outputDirectory);
		}

		final DependencyGatherer dependencyGatherer = new DependencyGatherer(pluginHelper, project, output);
		dependencyGatherer.handleBdioOutput();
	}

	public PluginHelper getPluginHelper() {
		return pluginHelper;
	}

	public void setPluginHelper(final PluginHelper pluginHelper) {
		this.pluginHelper = pluginHelper;
	}

	public String getOutputDirectory() {
		return outputDirectory;
	}

	public void setOutputDirectory(final String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

}
