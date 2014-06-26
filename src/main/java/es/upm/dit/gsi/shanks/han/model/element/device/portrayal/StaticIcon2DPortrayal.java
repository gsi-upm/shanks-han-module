/**
 * Copyright 2014 Álvaro Carrera Barroso
 * Grupo de Sistemas Inteligentes - Universidad Politécnica de Madrid
 *  
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.upm.dit.gsi.shanks.han.model.element.device.portrayal;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;

import sim.display.Display2D;
import sim.portrayal.DrawInfo2D;
import es.upm.dit.gsi.shanks.ShanksSimulation;
import es.upm.dit.gsi.shanks.exception.ShanksException;
import es.upm.dit.gsi.shanks.model.element.device.portrayal.Device2DPortrayal;
import es.upm.dit.gsi.shanks.model.scenario.portrayal.Scenario2DPortrayal;

/**
 * Project: shanks-han-module File:
 * es.upm.dit.gsi.shanks.han.model.scenario.portrayal.StaticIcon2DPortrayal.java
 * 
 * Grupo de Sistemas Inteligentes Departamento de Ingeniería de Sistemas
 * Telemáticos Universidad Politécnica de Madrid (UPM)
 * 
 * @author Álvaro Carrera Barroso
 * @email a.carrera@gsi.dit.upm.es
 * @twitter @alvarocarrera
 * @date 26/06/2014
 * @version 0.1
 * 
 */
public class StaticIcon2DPortrayal extends Device2DPortrayal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5486154563070637705L;
	private Image image = null;
	private ImageObserver io = null;

	/**
	 * Constructor
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public StaticIcon2DPortrayal(String filePath) throws IOException {
		if (image == null) {
			image = ImageLoaderHelper.getImage(filePath);
		}
		if (io == null) {
			io = ImageLoaderHelper.getImageObserver();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.upm.dit.gsi.shanks.model.element.device.portrayal.Device2DPortrayal
	 * #draw(java.lang.Object, java.awt.Graphics2D, sim.portrayal.DrawInfo2D)
	 */
	@Override
	public void draw(Object object, Graphics2D graphics, DrawInfo2D info) {

		ShanksSimulation sim = (ShanksSimulation) info.gui.state;
		double scale = 1.0;
		try {
			Scenario2DPortrayal scenarioPortrayal = (Scenario2DPortrayal) sim
					.getScenarioPortrayal();
			Display2D mainDisplay = scenarioPortrayal.getDisplays().get(
					Scenario2DPortrayal.MAIN_DISPLAY_ID);
			scale = mainDisplay.getScale();
		} catch (ShanksException e) {
			sim.getLogger().warning(
					"Problems to get the scale in the main display window. Exception message: "
							+ e.getMessage());
		}

		// Draw the devices
		double width = image.getWidth(io) * scale;
		double height = image.getHeight(io) * scale;
		final int x = (int) (info.draw.x - width / 2.0);
		final int y = (int) (info.draw.y - height / 2.0);
		final int w = (int) (width);
		final int h = (int) (height);

		// graphics.setXORMode(Color.red);
		graphics.drawImage(image, x, y, w, h, io);
		// graphics.setPaintMode();

	}
}
