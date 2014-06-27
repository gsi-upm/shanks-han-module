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
package es.upm.dit.gsi.shanks.han.model.scenario.portrayal;

import sim.portrayal.continuous.ContinuousPortrayal2D;
import sim.portrayal.network.NetworkPortrayal2D;
import es.upm.dit.gsi.shanks.exception.ShanksException;
import es.upm.dit.gsi.shanks.han.model.element.device.AndroidSetTopBox;
import es.upm.dit.gsi.shanks.han.model.element.device.Desktop;
import es.upm.dit.gsi.shanks.han.model.element.device.IPTVSetTopBox;
import es.upm.dit.gsi.shanks.han.model.element.device.Laptop;
import es.upm.dit.gsi.shanks.han.model.element.device.ONT;
import es.upm.dit.gsi.shanks.han.model.element.device.Printer;
import es.upm.dit.gsi.shanks.han.model.element.device.Router;
import es.upm.dit.gsi.shanks.han.model.element.device.Server;
import es.upm.dit.gsi.shanks.han.model.element.device.SmartPhone;
import es.upm.dit.gsi.shanks.han.model.element.device.Switch;
import es.upm.dit.gsi.shanks.han.model.element.device.TV;
import es.upm.dit.gsi.shanks.han.model.element.device.WifiAP;
import es.upm.dit.gsi.shanks.han.model.element.device.portrayal.StaticIcon2DPortrayal;
import es.upm.dit.gsi.shanks.han.model.element.link.portrayal.HANLink2DPortrayal;
import es.upm.dit.gsi.shanks.model.element.device.Device;
import es.upm.dit.gsi.shanks.model.element.link.Link;
import es.upm.dit.gsi.shanks.model.scenario.Scenario;
import es.upm.dit.gsi.shanks.model.scenario.portrayal.Scenario2DPortrayal;
import es.upm.dit.gsi.shanks.model.scenario.portrayal.ScenarioPortrayal;

/**
 * Project: shanks-han-module File:
 * es.upm.dit.gsi.shanks.han.model.scenario.portrayal
 * .HANScenario2DPortrayal.java
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
public class HANScenario2DPortrayal extends Scenario2DPortrayal {

	/**
	 * Constructor
	 * 
	 * @param scenario
	 * @param width
	 * @param height
	 * @throws ShanksException
	 */
	public HANScenario2DPortrayal(Scenario scenario, int width, int height) throws ShanksException {
		super(scenario, width, height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.upm.dit.gsi.shanks.model.scenario.portrayal.Scenario2DPortrayal#
	 * addPortrayals()
	 */
	@Override
	public void addPortrayals() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.upm.dit.gsi.shanks.model.scenario.portrayal.Scenario2DPortrayal#
	 * placeElements()
	 */
	@Override
	public void placeElements() {
		// *******************************
		// ROUTER
		// *******************************
		this.situateDevice((Device) this.getScenario().getNetworkElement("router"), 400, 80);
		this.situateDevice((Device) this.getScenario().getNetworkElement("ont"), 200, 80);

		this.drawLink((Link) this.getScenario().getNetworkElement("eth-ont-router"));

		// *******************************
		// LIVING ROOM
		// *******************************
		this.situateDevice((Device) this.getScenario().getNetworkElement("switch"), 250, 450);
		this.situateDevice((Device) this.getScenario().getNetworkElement("ap"), 80, 740);
		this.situateDevice((Device) this.getScenario().getNetworkElement("stb-iptv"), 450, 700);
		this.situateDevice((Device) this.getScenario().getNetworkElement("tv-living"), 450, 780);
		this.situateDevice((Device) this.getScenario().getNetworkElement("laptop-asus"), 275, 750);

		this.drawLink((Link) this.getScenario().getNetworkElement("hdmi-stb-tvliving"));
		this.drawLink((Link) this.getScenario().getNetworkElement("hdmi-asus-tvliving"));
		this.drawLink((Link) this.getScenario().getNetworkElement("eth-router-switch"));
		this.drawLink((Link) this.getScenario().getNetworkElement("eth-switch-asus"));
		this.drawLink((Link) this.getScenario().getNetworkElement("eth-switch-ap"));
		this.drawLink((Link) this.getScenario().getNetworkElement("eth-switch-stb"));

		// *******************************
		// BEDROOM
		// *******************************
		this.situateDevice((Device) this.getScenario().getNetworkElement("tv-bedroom"), 750, 650);
		this.situateDevice((Device) this.getScenario().getNetworkElement("android-stb"), 750, 750);

		this.drawLink((Link) this.getScenario().getNetworkElement("hdmi-androidstb-tvbedroom"));

		// *******************************
		// OFFICE
		// *******************************
		this.situateDevice((Device) this.getScenario().getNetworkElement("desktop-gea"), 780, 150);
		this.situateDevice((Device) this.getScenario().getNetworkElement("desktop-mystra"), 750, 50);
		this.situateDevice((Device) this.getScenario().getNetworkElement("server-prometeo"), 700, 250);
		this.situateDevice((Device) this.getScenario().getNetworkElement("printer"), 600, 20);

		this.drawLink((Link) this.getScenario().getNetworkElement("eth-router-gea"));
		this.drawLink((Link) this.getScenario().getNetworkElement("eth-router-mystra"));
		this.drawLink((Link) this.getScenario().getNetworkElement("eth-router-prometeo"));
		this.drawLink((Link) this.getScenario().getNetworkElement("usb-printer-mystra"));

		// *******************************
		// MOBILE
		// *******************************
		this.situateDevice((Device) this.getScenario().getNetworkElement("nexus"), 50, 250);
		this.situateDevice((Device) this.getScenario().getNetworkElement("ace"), 650, 450);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.upm.dit.gsi.shanks.model.scenario.portrayal.ScenarioPortrayal#
	 * setupPortrayals()
	 */
	@Override
	public void setupPortrayals() {
		try {
			ContinuousPortrayal2D devicePortrayal = (ContinuousPortrayal2D) this.getPortrayals()
					.get(Scenario2DPortrayal.MAIN_DISPLAY_ID).get(ScenarioPortrayal.DEVICES_PORTRAYAL);
			NetworkPortrayal2D networkPortrayal = (NetworkPortrayal2D) this.getPortrayals()
					.get(Scenario2DPortrayal.MAIN_DISPLAY_ID).get(ScenarioPortrayal.LINKS_PORTRAYAL);

			// Portrayals for devices
			devicePortrayal
					.setPortrayalForClass(TV.class, new StaticIcon2DPortrayal("src/main/resources/icons/tv.png"));
			devicePortrayal.setPortrayalForClass(IPTVSetTopBox.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/stb.png"));
			devicePortrayal.setPortrayalForClass(Switch.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/switch.png"));
			devicePortrayal.setPortrayalForClass(Router.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/wirelessrouter.png"));
			devicePortrayal.setPortrayalForClass(ONT.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/modem.png"));
			devicePortrayal.setPortrayalForClass(Laptop.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/laptop.png"));
			devicePortrayal.setPortrayalForClass(WifiAP.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/wirelessrouter.png"));
			devicePortrayal.setPortrayalForClass(AndroidSetTopBox.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/stb.png"));
			devicePortrayal.setPortrayalForClass(Desktop.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/pc.png"));
			devicePortrayal.setPortrayalForClass(Server.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/server.png"));
			devicePortrayal.setPortrayalForClass(Printer.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/printer.png"));
			devicePortrayal.setPortrayalForClass(SmartPhone.class, new StaticIcon2DPortrayal(
					"src/main/resources/icons/pda.png"));

			// Portrayals for links
			networkPortrayal.setPortrayalForAll(new HANLink2DPortrayal());
			// NOTE: All objects in the network portrayal are Edge. Thus, we
			// have to specify only one portrayal and paint different links in
			// the code of that portrayal.

		} catch (Exception e) {
			this.getScenario().getLogger()
					.warning("Error configuring portrayals for the simulation: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
