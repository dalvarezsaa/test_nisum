package com.test.nisum.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * 
 * @author Christian Rojas N.
 *
 */
public class SimpleErrorHandler implements ErrorHandler {

	private static final Logger log = LoggerFactory.getLogger(SimpleErrorHandler.class);

	/**
	 * Método que Devuelve Warnigns (Advertencias) durante el Parseo del XML
	 * 
	 * @param e Objeto del Tipo SAXParseException con la Excepción Lanzada Durante
	 *          el Parseo
	 * @author cristian.palavecinos
	 * @throws SAXException
	 *
	 */
	public void warning(SAXParseException e) throws SAXException {
		log.warn(e.getMessage());
	}

	/**
	 * Método que Devuelve Errores durante el Parseo del XML
	 * 
	 * @param e Objeto del Tipo SAXParseException con la Excepción Lanzada Durante
	 *          el Parseo
	 * @author cristian.palavecinos
	 * @throws SAXException
	 *
	 */
	public void error(SAXParseException e) throws SAXException {
		log.error(e.getMessage());
	}

	/**
	 * Método que Devuelve Errores Fatales durante el Parseo del XML
	 * 
	 * @param e Objeto del Tipo SAXParseException con la Excepción Lanzada Durante
	 *          el Parseo
	 * @author cristian.palavecinos
	 * @throws SAXException
	 *
	 */
	public void fatalError(SAXParseException e) throws SAXException {
		log.error(e.getMessage());
	}

}
