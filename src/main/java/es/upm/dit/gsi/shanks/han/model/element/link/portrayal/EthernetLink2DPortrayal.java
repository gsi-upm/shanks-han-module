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
package es.upm.dit.gsi.shanks.han.model.element.link.portrayal;

import java.awt.Color;
import java.awt.Graphics2D;

import sim.field.network.Edge;
import sim.portrayal.DrawInfo2D;
import sim.portrayal.network.EdgeDrawInfo2D;
import es.upm.dit.gsi.shanks.model.element.link.Link;
import es.upm.dit.gsi.shanks.model.element.link.portrayal.Link2DPortrayal;

/**
 * Project: shanks-han-module File:
 * es.upm.dit.gsi.shanks.han.model.scenario.portrayal
 * .EthernetLink2DPortrayal.java
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
public class EthernetLink2DPortrayal extends Link2DPortrayal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8311771359643667135L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.upm.dit.gsi.shanks.model.element.link.portrayal.Link2DPortrayal#draw
	 * (java.lang.Object, java.awt.Graphics2D, sim.portrayal.DrawInfo2D)
	 */
	public void draw(Object object, Graphics2D graphics, DrawInfo2D info) {
		Edge e = (Edge) object;

		Link link = (Link) e.getInfo();
		this.drawSimpleLink(link, object, graphics, info);

	}

	/**
	 * @param link
	 * @param object
	 * @param graphics
	 * @param info
	 */
	private void drawSimpleLink(Link link, Object object, Graphics2D graphics,
			DrawInfo2D info) {
		EdgeDrawInfo2D ei = (EdgeDrawInfo2D) info;

		final int startX = (int) ei.draw.x;
		final int startY = (int) ei.draw.y;
		final int endX = (int) ei.secondPoint.x;
		final int endY = (int) ei.secondPoint.y;
		final int midX = (int) (ei.draw.x + ei.secondPoint.x) / 2;
		final int midY = (int) (ei.draw.y + ei.secondPoint.y) / 2;

		graphics.setColor(Color.black);
		// HashMap<String, Boolean> status = link.getStatus();
		// if (status.get(MyLink.OK_STATUS)) {
		// graphics.setColor(Color.green);
		// } else if (status.get(MyLink.BROKEN_STATUS)) {
		// graphics.setColor(Color.red);
		// }
		graphics.drawLine(startX, startY, endX, endY);

		graphics.setColor(Color.blue);
		graphics.setFont(labelFont);
		int width = graphics.getFontMetrics().stringWidth(link.getID());
		graphics.drawString(link.getID(), midX - width / 2, midY);
	}
}
