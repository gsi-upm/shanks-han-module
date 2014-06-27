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
package es.upm.dit.gsi.shanks.han.model.element.device;

import java.util.logging.Logger;

/**
 * Project: shanks-han-module File:
 * es.upm.dit.gsi.shanks.han.model.element.device.Desktop.java
 * 
 * Grupo de Sistemas Inteligentes Departamento de Ingeniería de Sistemas
 * Telemáticos Universidad Politécnica de Madrid (UPM)
 * 
 * @author Álvaro Carrera Barroso
 * @email a.carrera@gsi.dit.upm.es
 * @twitter @alvarocarrera
 * @date 25/06/2014
 * @version 0.1
 * 
 */
public class Desktop extends Computer {

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param initialState
	 * @param isGateway
	 * @param logger
	 */
	public Desktop(String id, String initialState, boolean isGateway, Logger logger) {
		super(id, initialState, isGateway, logger);
		// TODO Auto-generated constructor stub
	}

}
