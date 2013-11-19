package br.com.gigio.audittore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.gigio.audittore.audit.aspectj.interfaces.Audittable;

/**
 * Help Controller, displays some help...
 * 
 * @author gribeiro
 * 
 */
@Controller()
public class HelpController {

	@Audittable
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String showHelp(@RequestParam int pageId, Model model) {

		String help = getHelpPage(pageId);

		model.addAttribute("helpText", help);
		return "help";
	}

	private String getHelpPage(int pageId) {
		return "This is the help text - The Beetles are in Stereo";
	}

}
