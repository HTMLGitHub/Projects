/**
 * 
 */
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import service.MonsterService;
import service.ItemService;
import service.PlayerService;
import service.QuestService;

/**
 * @author bak12
 *
 */
@Controller("WorldController")
@CrossOrigin(origins="http://localhost:4200")
public class WorldControllerImpl implements WorldController
{
	@Autowired
	private MonsterService creatureService;
	private ItemService itemService;
	private PlayerService playerService;
	private QuestService questService;
}