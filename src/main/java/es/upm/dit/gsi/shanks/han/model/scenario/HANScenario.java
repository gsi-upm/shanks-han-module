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
package es.upm.dit.gsi.shanks.han.model.scenario;

import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

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
import es.upm.dit.gsi.shanks.han.model.element.link.EthernetLink;
import es.upm.dit.gsi.shanks.han.model.element.link.HDMICable;
import es.upm.dit.gsi.shanks.han.model.element.link.USBCable;
import es.upm.dit.gsi.shanks.han.model.element.link.WifiLink;
import es.upm.dit.gsi.shanks.han.model.scenario.portrayal.HANScenario2DPortrayal;
import es.upm.dit.gsi.shanks.model.event.failure.Failure;
import es.upm.dit.gsi.shanks.model.scenario.Scenario;
import es.upm.dit.gsi.shanks.model.scenario.portrayal.Scenario2DPortrayal;
import es.upm.dit.gsi.shanks.model.scenario.portrayal.Scenario3DPortrayal;

/**
 * Project: shanks-han-module File:
 * es.upm.dit.gsi.shanks.han.model.scenario.HANScenario.java
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
public class HANScenario extends Scenario {

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param initialState
	 * @param properties
	 * @param logger
	 * @throws ShanksException
	 */
	public HANScenario(String id, String initialState, Properties properties, Logger logger) throws ShanksException {
		super(id, initialState, properties, logger);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.upm.dit.gsi.shanks.model.scenario.Scenario#addNetworkElements()
	 */
	@Override
	public void addNetworkElements() throws ShanksException {

		// *******************************
		// ROUTER
		// *******************************

		// Router Devices
		ONT ont = new ONT("ont", "OK", false, this.getLogger());
		Router router = new Router("router", "OK", false, this.getLogger());

		// Router Links
		EthernetLink ethont = new EthernetLink("eth-ont-router", "OK", this.getLogger());

		// Connections in Router
		ethont.connectDevices(ont, router);

		// Add network elements to the simulation
		this.addNetworkElement(router);
		this.addNetworkElement(ont);
		this.addNetworkElement(ethont);

		// *******************************
		// LIVING ROOM
		// *******************************

		// Living room devices
		TV tvliving = new TV("tv-living", "OFF", false, this.getLogger());
		Switch switchliving = new Switch("switch", "OK", false, this.getLogger());
		WifiAP ap = new WifiAP("ap", "OK", false, this.getLogger());
		Laptop asus = new Laptop("laptop-asus", "OFF", false, this.getLogger());
		IPTVSetTopBox stb = new IPTVSetTopBox("stb-iptv", "OFF", false, this.getLogger());

		// Living room links
		HDMICable hdmistbiptv = new HDMICable("hdmi-stb-tvliving", "OK", this.getLogger());
		HDMICable hdmiasustv = new HDMICable("hdmi-asus-tvliving", "OK", this.getLogger());
		EthernetLink ethrouterswitch = new EthernetLink("eth-router-switch", "OK", this.getLogger());
		EthernetLink ethswitchasus = new EthernetLink("eth-switch-asus", "OK", this.getLogger());
		EthernetLink ethswitchap = new EthernetLink("eth-switch-ap", "OK", this.getLogger());
		EthernetLink ethswitchstb = new EthernetLink("eth-switch-stb", "OK", this.getLogger());

		// Connections in Living room
		hdmistbiptv.connectDevices(stb, tvliving);
		hdmiasustv.connectDevices(asus, tvliving);
		ethrouterswitch.connectDevices(router, switchliving);
		ethswitchap.connectDevices(switchliving, ap);
		ethswitchasus.connectDevices(switchliving, asus);
		ethswitchstb.connectDevices(switchliving, stb);

		// Adds network elements to the simulation
		this.addNetworkElement(tvliving);
		this.addNetworkElement(switchliving);
		this.addNetworkElement(ap);
		this.addNetworkElement(asus);
		this.addNetworkElement(stb);
		this.addNetworkElement(hdmistbiptv);
		this.addNetworkElement(hdmiasustv);
		this.addNetworkElement(ethrouterswitch);
		this.addNetworkElement(ethswitchasus);
		this.addNetworkElement(ethswitchap);
		this.addNetworkElement(ethswitchstb);

		// *******************************
		// BEDROOM
		// *******************************

		// Bedroom devices
		TV tvbedroom = new TV("tv-bedroom", "OFF", false, this.getLogger());
		AndroidSetTopBox androidstb = new AndroidSetTopBox("android-stb", "OFF", false, this.getLogger());

		// Bedroom links
		HDMICable hdmiandroidtv = new HDMICable("hdmi-androidstb-tvbedroom", "OK", this.getLogger());
		WifiLink wifiandroidstb = new WifiLink("wifi-androidstb-router", "OK", this.getLogger());

		// Connections in Bedroom
		hdmiandroidtv.connectDevices(androidstb, tvbedroom);
		wifiandroidstb.connectDevices(androidstb, router);

		// Adds network elements to the simulation
		this.addNetworkElement(tvbedroom);
		this.addNetworkElement(androidstb);
		this.addNetworkElement(hdmiandroidtv);
		this.addNetworkElement(wifiandroidstb);

		// *******************************
		// OFFICE
		// *******************************

		// Office Devices
		Desktop gea = new Desktop("desktop-gea", "OFF", false, this.getLogger());
		Desktop mystra = new Desktop("desktop-mystra", "OFF", false, this.getLogger());
		Server prometeo = new Server("server-prometeo", "OFF", false, this.getLogger());
		Printer printer = new Printer("printer", "OFF", false, this.getLogger());

		// Office Links
		EthernetLink ethgea = new EthernetLink("eth-router-gea", "OK", this.getLogger());
		EthernetLink ethmystra = new EthernetLink("eth-router-mystra", "OK", this.getLogger());
		EthernetLink ethprometeo = new EthernetLink("eth-router-prometeo", "OK", this.getLogger());
		USBCable usbprinter = new USBCable("usb-printer-mystra", "OK", this.getLogger());
		WifiLink wifiprinter = new WifiLink("wifi-router-printer", "OK", this.getLogger());

		// Connections in Office
		ethgea.connectDevices(router, gea);
		ethmystra.connectDevices(router, mystra);
		ethprometeo.connectDevices(router, prometeo);
		usbprinter.connectDevices(printer, mystra);
		wifiprinter.connectDevices(router, printer);

		// Adds network elements to the simulation
		this.addNetworkElement(gea);
		this.addNetworkElement(mystra);
		this.addNetworkElement(prometeo);
		this.addNetworkElement(ethgea);
		this.addNetworkElement(ethmystra);
		this.addNetworkElement(ethprometeo);
		this.addNetworkElement(printer);
		this.addNetworkElement(usbprinter);
		this.addNetworkElement(wifiprinter);

		// *******************************
		// MOBILE
		// *******************************

		// Mobile Devices
		SmartPhone nexus = new SmartPhone("nexus", "OFF", false, this.getLogger());
		SmartPhone ace = new SmartPhone("ace", "OFF", false, this.getLogger());

		// Mobile Links
		WifiLink wifinexus = new WifiLink("wifi-router-nexus", "OK", this.getLogger());
		WifiLink wifiace = new WifiLink("wifi-router-ace", "OK", this.getLogger());

		// Connections in Mobile
		wifinexus.connectDevices(router, nexus);
		wifiace.connectDevices(router, ace);

		// Adds network elements to the simulation
		this.addNetworkElement(nexus);
		this.addNetworkElement(ace);
		this.addNetworkElement(wifinexus);
		this.addNetworkElement(wifiace);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.upm.dit.gsi.shanks.model.scenario.Scenario#addPossibleEvents()
	 */
	@Override
	public void addPossibleEvents() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.upm.dit.gsi.shanks.model.scenario.Scenario#addPossibleFailures()
	 */
	@Override
	public void addPossibleFailures() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.upm.dit.gsi.shanks.model.scenario.Scenario#createScenario2DPortrayal()
	 */
	@Override
	public Scenario2DPortrayal createScenario2DPortrayal() throws ShanksException {
		return new HANScenario2DPortrayal(this, 800, 800);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.upm.dit.gsi.shanks.model.scenario.Scenario#createScenario3DPortrayal()
	 */
	@Override
	public Scenario3DPortrayal createScenario3DPortrayal() throws ShanksException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.upm.dit.gsi.shanks.model.scenario.Scenario#getPenaltiesInStatus(java
	 * .lang.String)
	 */
	@Override
	public HashMap<Class<? extends Failure>, Double> getPenaltiesInStatus(String arg0) throws ShanksException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.upm.dit.gsi.shanks.model.scenario.Scenario#setPossibleStates()
	 */
	@Override
	public void setPossibleStates() {
		this.addPossibleStatus("OK");

	}

}
