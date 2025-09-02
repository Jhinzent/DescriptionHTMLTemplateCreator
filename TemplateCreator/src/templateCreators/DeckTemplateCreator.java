package templateCreators;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import helpers.Card;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeckTemplateCreator {
	

	ArrayList<Card> monsterData = new ArrayList<>();
	ArrayList<Card> spellTrapData = new ArrayList<>();
	ArrayList<Card> extraData = new ArrayList<>();
	ArrayList<Card> relatedCards = new ArrayList<>();
	
	private String outputString = "";

	public DeckTemplateCreator(ArrayList<Card> monsterData, ArrayList<Card> spellTrapData, ArrayList<Card> extraData, ArrayList<Card> relatedCards) {

		this.monsterData = monsterData;
		this.spellTrapData = spellTrapData;
		this.extraData = extraData;
		this.relatedCards = relatedCards;
	}
	
	public void createAndSave() {
	    String masterText = createString();

	    try {
	        // Create the file
	        File file = new File("output/output.html");

	        // Close the file if it is open
	        FileWriter writer = new FileWriter(file, true);
	        writer.close();

	        // Delete the old file
	        if (file.exists()) {
	            file.delete();
	        }

	        // Create a new file
	        file.createNewFile();

	        // Write to the file
	        writer = new FileWriter(file);
	        writer.write(masterText);
	        writer.close();

	        outputString = "";
	        masterText = "";

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private String createString() {
		outputString = "";
		
		outputString = outputString + "<div\r\n"
				+ "  style=\"\r\n"
				+ "    border: 1px solid rgb(217, 217, 217);\r\n"
				+ "    height: max-content;\r\n"
				+ "    min-height: 1200px;\r\n"
				+ "    background-color: rgb(250, 250, 250);\r\n"
				+ "    font-family: 'Microsoft Sans Serif', sans-serif;\r\n"
				+ "  \"\r\n"
				+ ">\r\n"
				+ "  <link\r\n"
				+ "    rel=\"stylesheet\"\r\n"
				+ "    href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css\"\r\n"
				+ "  />\r\n"
				+ "  <style type=\"text/css\" scoped=\"\">\r\n"
				+ "    /* Top Part */\r\n"
				+ "    #topBar {\r\n"
				+ "      background-color: rgb(255, 255, 255);\r\n"
				+ "      box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;\r\n"
				+ "      min-height: 150px;\r\n"
				+ "    }\r\n"
				+ "    #topBarColor {\r\n"
				+ "      height: 30px;\r\n"
				+ "      background-color: rgba(222, 40, 183, 0.762);\r\n"
				+ "      border: solid rgb(199, 199, 199);\r\n"
				+ "      border-width: 0px 0px 1px 0px;\r\n"
				+ "    }\r\n"
				+ "    #topBarLabelContainer {\r\n"
				+ "      padding-top: 15px;\r\n"
				+ "    }\r\n"
				+ "    #topBarLabel {\r\n"
				+ "      background-color: white;\r\n"
				+ "      border: solid 1px rgb(250, 250, 250);\r\n"
				+ "      border-radius: 2px;\r\n"
				+ "      padding: 9px 15px 10px 9px;\r\n"
				+ "      margin-right: 20px;\r\n"
				+ "      float: right;\r\n"
				+ "      text-shadow: rgba(0, 0, 0, 0.145) 5px 5px 10px;\r\n"
				+ "    }\r\n"
				+ "    /* Descr Containers */\r\n"
				+ "    #descContainerGer,\r\n"
				+ "    #descContainerEng {\r\n"
				+ "      width: 95%;\r\n"
				+ "      height: fit-content;\r\n"
				+ "      box-shadow: rgba(0, 0, 0, 0.145) 0px 5px 15px 10px;\r\n"
				+ "      margin-top: 2.5%;\r\n"
				+ "      margin-left: auto;\r\n"
				+ "      margin-right: auto;\r\n"
				+ "      background-color: white;\r\n"
				+ "      padding: 10px;\r\n"
				+ "      display: flex;\r\n"
				+ "    }\r\n"
				+ "    @media only screen and (max-width: 768px) {\r\n"
				+ "      /* For mobile phones: */\r\n"
				+ "      #descContainerGer,\r\n"
				+ "      #descContainerEng {\r\n"
				+ "        display: block;\r\n"
				+ "      }\r\n"
				+ "      #topBar {\r\n"
				+ "        min-height: 80px;\r\n"
				+ "      }\r\n"
				+ "      #languageButtonsDiv {\r\n"
				+ "        display: none;\r\n"
				+ "      }\r\n"
				+ "      #cardListConainer {\r\n"
				+ "        width: 100%;\r\n"
				+ "        padding: 1%;\r\n"
				+ "      }\r\n"
				+ "      .hiddenHeader {\r\n"
				+ "        display: block;\r\n"
				+ "      }\r\n"
				+ "      #categoryChooserDiv {\r\n"
				+ "        display: none;\r\n"
				+ "      }\r\n"
				+ "      .variableDescr {\r\n"
				+ "        display: block;\r\n"
				+ "      }\r\n"
				+ "      #hintContainer {\r\n"
				+ "        display: none;\r\n"
				+ "      }\r\n"
				+ "      #descrTextContainer {\r\n"
				+ "        width: 88%;\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "    @media only screen and (min-width: 769px) {\r\n"
				+ "      /* For PC: */\r\n"
				+ "      #cardListConainer {\r\n"
				+ "        width: 45%;\r\n"
				+ "        padding: 1%;\r\n"
				+ "      }\r\n"
				+ "      .hiddenHeader {\r\n"
				+ "        display: none;\r\n"
				+ "      }\r\n"
				+ "      #categoryChooserDiv {\r\n"
				+ "        display: flex;\r\n"
				+ "      }\r\n"
				+ "      .variableDescr {\r\n"
				+ "        display: none;\r\n"
				+ "      }\r\n"
				+ "      #descrTextContainer {\r\n"
				+ "        width: 50%;\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "    #categoryChooserDiv {\r\n"
				+ "      justify-content: space-around;\r\n"
				+ "    }\r\n"
				+ "    .categoryChooser {\r\n"
				+ "      border-radius: 2px;\r\n"
				+ "      box-shadow: 0px 2px 13px 0px rgba(0, 0, 0, 0.35);\r\n"
				+ "      cursor: pointer;\r\n"
				+ "      color: black;\r\n"
				+ "      text-align: center;\r\n"
				+ "      padding: 10px;\r\n"
				+ "      min-width: 120px;\r\n"
				+ "    }\r\n"
				+ "    #mosnterDescEng:target {\r\n"
				+ "      display: block;\r\n"
				+ "    }\r\n"
				+ "    #mosnterDescEng:target ~ #hintContainer {\r\n"
				+ "      display: none;\r\n"
				+ "    }\r\n"
				+ "    #spellTrapDescEng:target {\r\n"
				+ "      display: block;\r\n"
				+ "    }\r\n"
				+ "    #spellTrapDescEng:target ~ #hintContainer {\r\n"
				+ "      display: none;\r\n"
				+ "    }\r\n"
				+ "    #extraDescEng:target {\r\n"
				+ "      display: block;\r\n"
				+ "    }\r\n"
				+ "    #extraDescEng:target ~ #hintContainer {\r\n"
				+ "      display: none;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    /* */\r\n"
				+ "\r\n"
				+ "    #descContainerGer {\r\n"
				+ "      display: none;\r\n"
				+ "    }\r\n"
				+ "    #descContainerGer:target {\r\n"
				+ "      display: flex;\r\n"
				+ "    }\r\n"
				+ "    #descContainerGer:target ~ #descContainerEng {\r\n"
				+ "      display: none;\r\n"
				+ "    }\r\n"
				+ "    #descContainerEng:target {\r\n"
				+ "      display: flex;\r\n"
				+ "    }\r\n"
				+ "    #descContainerEng:target ~ #descContainerGer {\r\n"
				+ "      display: none;\r\n"
				+ "    }\r\n"
				+ "    #langueChooseDiv {\r\n"
				+ "      float: right;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    /* */\r\n"
				+ "\r\n"
				+ "    #hintContainer {\r\n"
				+ "      padding: 5%;\r\n"
				+ "      text-align: center;\r\n"
				+ "    }\r\n"
				+ "    #hintContainer small {\r\n"
				+ "      margin: 0px 10px 0px 10px;\r\n"
				+ "    }\r\n"
				+ "    #variableDecrContainerInner {\r\n"
				+ "      height: max-content;\r\n"
				+ "      background-color: rgb(249, 249, 249);\r\n"
				+ "      box-shadow: rgba(0, 0, 0, 0.145) 0px 5px 15px 3px;\r\n"
				+ "      margin-top: 2%;\r\n"
				+ "    }\r\n"
				+ "    a:link {\r\n"
				+ "      text-decoration: none !important;\r\n"
				+ "    }\r\n"
				+ "    #enableMonsterButton {\r\n"
				+ "      background-color: rgb(235, 235, 235);\r\n"
				+ "    }\r\n"
				+ "    #enableSpellTrapButton {\r\n"
				+ "      background-color: rgb(225, 225, 225);\r\n"
				+ "    }\r\n"
				+ "    #enableExtraButton {\r\n"
				+ "      background-color: rgb(235, 235, 235);\r\n"
				+ "    }\r\n"
				+ "    /* Descr Contents */\r\n"
				+ "    .deckList {\r\n"
				+ "      list-style: none;\r\n"
				+ "      margin-bottom: 20px;\r\n"
				+ "    }\r\n"
				+ "    .deckList ul {\r\n"
				+ "      width: 90%;\r\n"
				+ "      border-bottom: solid 2px rgb(0, 200, 190);\r\n"
				+ "\r\n"
				+ "      margin: 0px auto;\r\n"
				+ "      padding: 10px 0px 10px 0px;\r\n"
				+ "\r\n"
				+ "      text-align: center;\r\n"
				+ "      font-size: 0.95em;\r\n"
				+ "    }\r\n"
				+ "    #deckCoreNameHeader {\r\n"
				+ "      margin-top: 1%;\r\n"
				+ "      margin-left: 10px;\r\n"
				+ "    }\r\n"
				+ "    #descrTextContainer {\r\n"
				+ "      box-shadow: rgba(0, 0, 0, 0.145) 0px 5px 15px 3px;\r\n"
				+ "      margin: 2%;\r\n"
				+ "      padding: 4%;\r\n"
				+ "    }\r\n"
				+ "    .infoHeader {\r\n"
				+ "      padding: 10px;\r\n"
				+ "      border-bottom: solid 2px rgb(182, 182, 182);\r\n"
				+ "      margin-bottom: 20px;\r\n"
				+ "    }\r\n"
				+ "    .infoContent {\r\n"
				+ "      margin: 0px 0px 0px 10px;\r\n"
				+ "    }\r\n"
				+ "    .infoContainer {\r\n"
				+ "      margin-bottom: 10%;\r\n"
				+ "    }\r\n"
				+ "    #cardListHeader {\r\n"
				+ "      text-align: center;\r\n"
				+ "      border-bottom: solid 2px rgb(182, 182, 182);\r\n"
				+ "      margin-bottom: 20px;\r\n"
				+ "      padding-bottom: 20px;\r\n"
				+ "      width: 85%;\r\n"
				+ "      margin-left: 7.5%;\r\n"
				+ "      /* RARITYS */\r\n"
				+ "    }\r\n"
				+ "    .descrRarity {\r\n"
				+ "      margin-left: 5px;\r\n"
				+ "      padding: 5px 2px 5px 2px;\r\n"
				+ "      border-radius: 5px;\r\n"
				+ "      min-width: 20px;\r\n"
				+ "      box-shadow: 3px 2px 5px 0px rgba(0, 0, 0, 0.35);\r\n"
				+ "\r\n"
				+ "      display: inline-block;\r\n"
				+ "    }\r\n"
				+ "    #descrRarityC {\r\n"
				+ "      background: linear-gradient(\r\n"
				+ "          45deg,\r\n"
				+ "          #bebebe,\r\n"
				+ "          #989898 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          -45deg,\r\n"
				+ "          #a5a5a5,\r\n"
				+ "          #a2a2a2 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          135deg,\r\n"
				+ "          #b0b0b0,\r\n"
				+ "          #828282 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        );\r\n"
				+ "      background-size: 100% 100%;\r\n"
				+ "      background-repeat: no-repeat;\r\n"
				+ "    }\r\n"
				+ "    #descrRarityR {\r\n"
				+ "      background: linear-gradient(\r\n"
				+ "          45deg,\r\n"
				+ "          #d2d2d2,\r\n"
				+ "          #bfbfbf 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          -45deg,\r\n"
				+ "          #e6e6e6,\r\n"
				+ "          #a8a8a8 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          135deg,\r\n"
				+ "          #d0d0d0,\r\n"
				+ "          #c1c1c1 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        );\r\n"
				+ "      background-size: 100% 100%;\r\n"
				+ "      background-repeat: no-repeat;\r\n"
				+ "    }\r\n"
				+ "    #descrRarityUR {\r\n"
				+ "      background: linear-gradient(\r\n"
				+ "          45deg,\r\n"
				+ "          rgb(255, 248, 37),\r\n"
				+ "          rgb(255, 244, 37) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          -45deg,\r\n"
				+ "          rgb(255, 208, 20),\r\n"
				+ "          rgb(255, 231, 19) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          135deg,\r\n"
				+ "          rgb(248, 215, 0),\r\n"
				+ "          rgb(255, 224, 24) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        );\r\n"
				+ "      background-size: 100% 100%;\r\n"
				+ "      background-repeat: no-repeat;\r\n"
				+ "\r\n"
				+ "    }\r\n"
				+ "    #descrRaritySR {\r\n"
				+ "      background: linear-gradient(\r\n"
				+ "          45deg,\r\n"
				+ "          rgb(255, 215, 37),\r\n"
				+ "          rgb(244, 204, 24) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          -45deg,\r\n"
				+ "          rgb(250, 218, 91),\r\n"
				+ "          rgb(255, 235, 52) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          135deg,\r\n"
				+ "          rgb(255, 196, 35),\r\n"
				+ "          rgb(253, 179, 50) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        );\r\n"
				+ "      background-size: 100% 100%;\r\n"
				+ "      background-repeat: no-repeat;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    #descrRaritySER {\r\n"
				+ "      background: linear-gradient(\r\n"
				+ "          45deg,\r\n"
				+ "          #fff562,\r\n"
				+ "          #fff12d 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          -45deg,\r\n"
				+ "          #eade30,\r\n"
				+ "          #fbed23 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          135deg,\r\n"
				+ "          rgb(255, 217, 80),\r\n"
				+ "          rgb(240, 255, 80) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        );\r\n"
				+ "      background-size: 100% 100%;\r\n"
				+ "      background-repeat: no-repeat;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    #descrRarityGLD {\r\n"
				+ "      background: linear-gradient(\r\n"
				+ "          45deg,\r\n"
				+ "          rgb(255, 204, 19),\r\n"
				+ "          rgb(224, 178, 13) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          -45deg,\r\n"
				+ "          rgb(231, 198, 7),\r\n"
				+ "          rgb(225, 195, 2) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          135deg,\r\n"
				+ "          rgb(233, 184, 4),\r\n"
				+ "          rgb(255, 206, 31) 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        );\r\n"
				+ "      background-size: 100% 100%;\r\n"
				+ "      background-repeat: no-repeat;\r\n"
				+ "    }\r\n"
				+ "    #descrRarityCOL {\r\n"
				+ "      background: linear-gradient(\r\n"
				+ "          45deg,\r\n"
				+ "          #ff1e6d,\r\n"
				+ "          #e12063 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          -45deg,\r\n"
				+ "          #ce1455,\r\n"
				+ "          #9a0d3f 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          135deg,\r\n"
				+ "          #ce245f,\r\n"
				+ "          #da2d6a 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        );\r\n"
				+ "      background-size: 100% 100%;\r\n"
				+ "      background-repeat: no-repeat;\r\n"
				+ "    }\r\n"
				+ "    #descrRarityULT {\r\n"
				+ "      background: linear-gradient(\r\n"
				+ "          45deg,\r\n"
				+ "          #8a8a8a,\r\n"
				+ "          #8b8b8b 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          -45deg,\r\n"
				+ "          #c6c6c6,\r\n"
				+ "          #c6c6c6 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        ),\r\n"
				+ "        linear-gradient(\r\n"
				+ "          135deg,\r\n"
				+ "          #909090,\r\n"
				+ "          #828282 50%,\r\n"
				+ "          transparent 50%,\r\n"
				+ "          transparent\r\n"
				+ "        );\r\n"
				+ "      background-size: 100% 100%;\r\n"
				+ "      background-repeat: no-repeat;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    #languageButtonsDiv {\r\n"
				+ "      float: right;\r\n"
				+ "    }\r\n"
				+ "    /* */\r\n"
				+ "    #languageButtonsDiv a {\r\n"
				+ "      float: right;\r\n"
				+ "    }\r\n"
				+ "    #languageChooseHeader {\r\n"
				+ "      margin-top: 0px;\r\n"
				+ "      margin-bottom: 5px;\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "  <!-- body ------------------------------------------------------------- -->\r\n"
				+ "  <div id=\"topBar\">\r\n"
				+ "    <div id=\"topBarColor\">\r\n"
				+ "      <div id=\"topBarLabelContainer\">\r\n"
				+ "        <b id=\"topBarLabel\">JHINZENT</b>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "    <h3 class=\"header\" id=\"deckCoreNameHeader\">QNAMEQ Deck</h3>\r\n"
				+ "    <div id=\"languageButtonsDiv\">\r\n"
				+ "      <h4 class=\"header\" id=\"languageChooseHeader\">\r\n"
				+ "        Choose Description Language:\r\n"
				+ "      </h4>\r\n"
				+ "      <a href=\"#descContainerGer\">\r\n"
				+ "        <img\r\n"
				+ "          height=\"30px\"\r\n"
				+ "          width=\"60\"\r\n"
				+ "          src=\"https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/255px-Flag_of_Germany.svg.png\"\r\n"
				+ "        />\r\n"
				+ "      </a>\r\n"
				+ "      <a href=\"#descContainerEng\">\r\n"
				+ "        <img\r\n"
				+ "          height=\"30px\"\r\n"
				+ "          width=\"60\"\r\n"
				+ "          src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Flag_of_the_United_Kingdom_%281-2%29.svg/255px-Flag_of_the_United_Kingdom_%281-2%29.svg.png\"\r\n"
				+ "        />\r\n"
				+ "      </a>\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "  <div id=\"descContainerGer\">\r\n"
				+ "    <div id=\"cardListConainer\">\r\n"
				+ "      <h3 id=\"cardListHeader\">Card List</h3>\r\n"
				+ "      <div id=\"categoryChooserDiv\">\r\n"
				+ "        <a href=\"#mosnterDesc\">\r\n"
				+ "          <div class=\"categoryChooser\" id=\"enableMonsterButton\">Monster</div>\r\n"
				+ "        </a>\r\n"
				+ "        <a href=\"#spellTrapDesc\">\r\n"
				+ "          <div class=\"categoryChooser\" id=\"enableSpellTrapButton\">\r\n"
				+ "            Spells/Traps\r\n"
				+ "          </div>\r\n"
				+ "        </a>\r\n"
				+ "        <a href=\"#extraDesc\">\r\n"
				+ "          <div class=\"categoryChooser\" id=\"enableExtraButton\">Extra Deck</div>\r\n"
				+ "        </a>\r\n"
				+ "      </div>\r\n"
				+ "      <div id=\"variableDecrContainer\">\r\n"
				+ "        <div id=\"variableDecrContainerInner\">\r\n"
				+ "          <div id=\"hintContainer\">\r\n"
				+ "            <i class=\"fa-solid fa-arrow-up\"></i>\r\n"
				+ "            <small>Click the categorys above!</small>\r\n"
				+ "            <i class=\"fa-solid fa-arrow-up\"></i>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "    <div id=\"descrTextContainer\">\r\n"
				+ "      <div class=\"infoContainer\">\r\n"
				+ "        <h3 class=\"infoHeader\">Ähnliche Karten</h3>\r\n"
				+ "        <div>\r\n"
				+ "          <p class=\"infoContent\">\r\n"
				+ "            Wir haben eine große Auswahl an ähnlichen Karten, Zubehör und mehr\r\n"
				+ "            auf Lager!";
		
		ArrayList<Card> filteredRelatedText = relatedCards;
		for (int i = 0; i < filteredRelatedText.size(); i++) {
		    Card temp = filteredRelatedText.get(i);
		    if (temp.getName().isEmpty()) {
		    	filteredRelatedText.remove(i);
		        i--; // decrement the index to avoid skipping the next element
		    }
		}
		
		if(filteredRelatedText.size() > 0) {
			outputString = outputString + " Schauen Sie sich einige unserer Vorschläge für andere\r\n"
					+ "            Produkte an, die Sie interessieren könnten:\r\n"
					+ "          </p>\r\n"
					+ "          <ul>";
			for(Card tempCard: filteredRelatedText) {
				outputString = outputString + "<li>";
				outputString = outputString + tempCard.getName();
				if(!tempCard.getRarity().isEmpty()) {
					outputString = outputString + " | ";
					outputString = outputString + tempCard.getRarity();
				}
				outputString = outputString + "</li>";
			}
			outputString = outputString + "</ul>\r\n"
					+ "</div>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Versandinformationen</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          Alle Karten werden sicher verschickt, um während des\r\n"
					+ "          Transports geschützt zu sein.\r\n"
					+ "          <br /><br />\r\n"
					+ "          Mit unserer Versandoption \"Standard International\" werden Ihre Karten\r\n"
					+ "          in einem Brief mit Sendungsverfolgung verschickt, um Ihnen zusätzliche\r\n"
					+ "          Sicherheit zu geben.\r\n"
					+ "          <br /><br />\r\n"
					+ "          Wenn Sie eine andere Versandmethode bevorzugen oder Fragen zu unseren\r\n"
					+ "          Versandrichtlinien haben, können Sie uns gerne eine Nachricht senden.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Kartenzustand</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          Bitte beachten Sie, dass die Produktbilder möglicherweise nicht genau\r\n"
					+ "          der Karte entsprechen, die Sie erhalten werden. Der Zustand der Karte\r\n"
					+ "          entspricht jedoch immer den angegebenen Details.\r\n"
					+ "          <br /><br />\r\n"
					+ "          Wenn Sie Fragen zur angegebenen Bewertung oder zum Zustand einer\r\n"
					+ "          bestimmten Karte haben, zögern Sie bitte nicht, uns für weitere\r\n"
					+ "          Informationen zu kontaktieren.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n"
					+ "  <!-- ___________________________________________________________________________________________________________________ -->\r\n"
					+ "  <div id=\"descContainerEng\">\r\n"
					+ "    <div id=\"cardListConainer\">\r\n"
					+ "      <h3 class=\"header\" id=\"cardListHeader\">Card List</h3>\r\n"
					+ "      <div id=\"categoryChooserDiv\">\r\n"
					+ "        <a href=\"#mosnterDescEng\">\r\n"
					+ "          <div class=\"categoryChooser\" id=\"enableMonsterButton\">Monster</div>\r\n"
					+ "        </a>\r\n"
					+ "        <a href=\"#spellTrapDescEng\">\r\n"
					+ "          <div class=\"categoryChooser\" id=\"enableSpellTrapButton\">\r\n"
					+ "            Spells/Traps\r\n"
					+ "          </div>\r\n"
					+ "        </a>\r\n"
					+ "        <a href=\"#extraDescEng\">\r\n"
					+ "          <div class=\"categoryChooser\" id=\"enableExtraButton\">Extra Deck</div>\r\n"
					+ "        </a>\r\n"
					+ "      </div>\r\n"
					+ "      <div id=\"variableDecrContainer\">\r\n"
					+ "        <div id=\"variableDecrContainerInner\">\r\n"
					+ "          <div class=\"variableDescr\" id=\"mosnterDescEng\">\r\n"
					+ "            <li class=\"deckList\">\r\n"
					+ "              <ul class=\"hiddenHeader\">\r\n"
					+ "                <b>MONSTERS</b>\r\n"
					+ "              </ul>";
		}
		else {
			outputString = outputString + "</p>"
					+ "</div>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Versandinformationen</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          Alle Karten werden sicher in Toploadern verschickt, um während des\r\n"
					+ "          Transports geschützt zu sein.\r\n"
					+ "          <br /><br />\r\n"
					+ "          Mit unserer Versandoption \"Standard International\" werden Ihre Karten\r\n"
					+ "          in einem Brief mit Sendungsverfolgung verschickt, um Ihnen zusätzliche\r\n"
					+ "          Sicherheit zu geben.\r\n"
					+ "          <br /><br />\r\n"
					+ "          Wenn Sie eine andere Versandmethode bevorzugen oder Fragen zu unseren\r\n"
					+ "          Versandrichtlinien haben, können Sie uns gerne eine Nachricht senden.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Kartenzustand</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          Bitte beachten Sie, dass die Produktbilder möglicherweise nicht genau\r\n"
					+ "          der Karte entsprechen, die Sie erhalten werden. Der Zustand der Karte\r\n"
					+ "          entspricht jedoch immer den angegebenen Details.\r\n"
					+ "          <br /><br />\r\n"
					+ "          Wenn Sie Fragen zur angegebenen Bewertung oder zum Zustand einer\r\n"
					+ "          bestimmten Karte haben, zögern Sie bitte nicht, uns für weitere\r\n"
					+ "          Informationen zu kontaktieren.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n"
					+ "  <!-- ___________________________________________________________________________________________________________________ -->\r\n"
					+ "  <div id=\"descContainerEng\">\r\n"
					+ "    <div id=\"cardListConainer\">\r\n"
					+ "      <h3 class=\"header\" id=\"cardListHeader\">Card List</h3>\r\n"
					+ "      <div id=\"categoryChooserDiv\">\r\n"
					+ "        <a href=\"#mosnterDescEng\">\r\n"
					+ "          <div class=\"categoryChooser\" id=\"enableMonsterButton\">Monster</div>\r\n"
					+ "        </a>\r\n"
					+ "        <a href=\"#spellTrapDescEng\">\r\n"
					+ "          <div class=\"categoryChooser\" id=\"enableSpellTrapButton\">\r\n"
					+ "            Spells/Traps\r\n"
					+ "          </div>\r\n"
					+ "        </a>\r\n"
					+ "        <a href=\"#extraDescEng\">\r\n"
					+ "          <div class=\"categoryChooser\" id=\"enableExtraButton\">Extra Deck</div>\r\n"
					+ "        </a>\r\n"
					+ "      </div>\r\n"
					+ "      <div id=\"variableDecrContainer\">\r\n"
					+ "        <div id=\"variableDecrContainerInner\">\r\n"
					+ "          <div class=\"variableDescr\" id=\"mosnterDescEng\">\r\n"
					+ "            <li class=\"deckList\">\r\n"
					+ "              <ul class=\"hiddenHeader\">\r\n"
					+ "                <b>MONSTERS</b>\r\n"
					+ "              </ul>\r\n";
		}
		
		// MONSTERS
		
		if(monsterData.size() == 0) {
			outputString = outputString + "<ul>\r\n"
					+ "                Deck does not contain monster cards. \r\n"
					+ "              </ul>";
		}
		else {
			for(Card tempCard : monsterData) {
				outputString = outputString + "              <ul>\r\n";
				if(tempCard.getName().equals("")) outputString = outputString + "ERROR COULD NOT READ CARD NAME\r\n";
				else {
					outputString = outputString + "              	" + tempCard.getName();
					outputString = outputString + " " + tempCard.getNumOfCopys() + "x\r\n";
				}
				if(tempCard.getRarity().equals("")) outputString = outputString + "ERROR COULD NOT READ CARD RARITY\r\n";
				else {
					outputString = outputString + "              	<b class=\"descrRarity\" id=\"descrRarity";
					String tempRarityString = "";
					
					switch(tempCard.getRarity()) {
						case "Secret Rare" : tempRarityString = "SER"; break;
						case "Ultra Rare" : tempRarityString = "UR"; break;
						case "Super Rare" : tempRarityString = "SR"; break;
						case "Rare" : tempRarityString = "R"; break;
						case "Common" : tempRarityString = "C"; break;
						case "Ultimate Rare" : tempRarityString = "ULT"; break;
						case "Collectors Rare" : tempRarityString = "COL"; break;
						case "Gold Rare" : tempRarityString = "GLD"; break;
						default : tempRarityString = "ERROR ERROR ERROR"; break;
					}
					outputString = outputString + tempRarityString;
					outputString = outputString + "\">";
					outputString = outputString + tempRarityString + "</b>\r\n";
					outputString = outputString + "              </ul>\r\n";
				}
			}
		}
		
		outputString = outputString + "             </li>\r\n"
				+ "          </div>\r\n"
				+ "          <!-- ___________________________________________________________________________________________________________________ -->\r\n"
				+ "          <div class=\"variableDescr\" id=\"spellTrapDescEng\">\r\n"
				+ "            <li class=\"deckList\">\r\n"
				+ "              <ul class=\"hiddenHeader\">\r\n"
				+ "                <b>SPELLS/TRAPS</b>\r\n"
				+ "              </ul>\r\n";
		
		// SPELLS/TRAPS
		
		if(spellTrapData.size() == 0) {
			outputString = outputString + "<ul>\r\n"
					+ "                Deck does not contain spell/trap cards. \r\n"
					+ "              </ul>";
		}
		else {
			for(Card tempCard : spellTrapData) {
				outputString = outputString + "              <ul>\r\n";
				if(tempCard.getName().equals("")) outputString = outputString + "ERROR COULD NOT READ CARD NAME\r\n";
				else {
					outputString = outputString + "              	" + tempCard.getName();
					outputString = outputString + " " + tempCard.getNumOfCopys() + "x\r\n";
				}
				if(tempCard.getRarity().equals("")) outputString = outputString + "ERROR COULD NOT READ CARD RARITY\r\n";
				else {
					outputString = outputString + "              	<b class=\"descrRarity\" id=\"descrRarity";
					String tempRarityString = "";
					
					switch(tempCard.getRarity()) {
						case "Secret Rare" : tempRarityString = "SER"; break;
						case "Ultra Rare" : tempRarityString = "UR"; break;
						case "Super Rare" : tempRarityString = "SR"; break;
						case "Rare" : tempRarityString = "R"; break;
						case "Common" : tempRarityString = "C"; break;
						case "Ultimate Rare" : tempRarityString = "ULT"; break;
						case "Collectors Rare" : tempRarityString = "COL"; break;
						case "Gold Rare" : tempRarityString = "GLD"; break;
						default : tempRarityString = "ERROR ERROR ERROR"; break;
					}
					outputString = outputString + tempRarityString;
					outputString = outputString + "\">";
					outputString = outputString + tempRarityString + "</b>\r\n";
					outputString = outputString + "              </ul>\r\n";
				}
			}
		}
		
		outputString = outputString + "             </li>\r\n"
				+ "          </div>\r\n"
				+ "          <!-- ___________________________________________________________________________________________________________________ -->\r\n"
				+ "          <div class=\"variableDescr\" id=\"extraDescEng\">\r\n"
				+ "            <li class=\"deckList\">\r\n"
				+ "              <ul class=\"hiddenHeader\">\r\n"
				+ "                <b>EXTRA DECK</b>\r\n"
				+ "              </ul>\r\n";
		
		// EXTRA DECK
		
		if(extraData.size() == 0) {
			outputString = outputString + "<ul>\r\n"
					+ "                Deck does not contain extra deck cards. \r\n"
					+ "              </ul>";
		}
		else {
			for(Card tempCard : extraData) {
				outputString = outputString + "              <ul>\r\n";
				if(tempCard.getName().equals("")) outputString = outputString + "ERROR COULD NOT READ CARD NAME\r\n";
				else {
					outputString = outputString + "              	" + tempCard.getName();
					outputString = outputString + " " + tempCard.getNumOfCopys() + "x\r\n";
				}
				if(tempCard.getRarity().equals("")) outputString = outputString + "ERROR COULD NOT READ CARD RARITY\r\n";
				else {
					outputString = outputString + "              	<b class=\"descrRarity\" id=\"descrRarity";
					String tempRarityString = "";
					
					switch(tempCard.getRarity()) {
						case "Secret Rare" : tempRarityString = "SER"; break;
						case "Ultra Rare" : tempRarityString = "UR"; break;
						case "Super Rare" : tempRarityString = "SR"; break;
						case "Rare" : tempRarityString = "R"; break;
						case "Common" : tempRarityString = "C"; break;
						case "Ultimate Rare" : tempRarityString = "ULT"; break;
						case "Collectors Rare" : tempRarityString = "COL"; break;
						case "Gold Rare" : tempRarityString = "GLD"; break;
						default : tempRarityString = "ERROR ERROR ERROR"; break;
					}
					outputString = outputString + tempRarityString;
					outputString = outputString + "\">";
					outputString = outputString + tempRarityString + "</b>\r\n";
					outputString = outputString + "              </ul>\r\n";
				}
			}
		}
		
		outputString = outputString + "             </li>\r\n"
				+ "          </div>\r\n"
				+ "          <div id=\"hintContainer\">\r\n"
				+ "            <i class=\"fa-solid fa-arrow-up\"></i>\r\n"
				+ "            <small>Click the categorys above!</small>\r\n"
				+ "            <i class=\"fa-solid fa-arrow-up\"></i>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "    <div id=\"descrTextContainer\">\r\n"
				+ "      <div class=\"infoContainer\">\r\n"
				+ "        <h3 class=\"infoHeader\">Related Cards</h3>\r\n"
				+ "        <div>\r\n"
				+ "          <p class=\"infoContent\">\r\n"
				+ "            We have a wide selection of related cards, accessories, and more in\r\n"
				+ "            stock!";
		
		if(filteredRelatedText.size() > 0) {
			outputString = outputString + " Check out some of our suggestions for other items you might\r\n"
					+ "            be interested in:\r\n"
					+ "          </p><ul>";
			for(Card tempCard: filteredRelatedText) {
				outputString = outputString + "<li>";
				outputString = outputString + tempCard.getName();
				if(!tempCard.getRarity().isEmpty()) {
					outputString = outputString + " | ";
					outputString = outputString + tempCard.getRarity();
				}
				outputString = outputString + "</li>";
			}
			outputString = outputString + "</ul>\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Shipping Info</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          All cards are shipped safely to ensure their protection during\r\n"
					+ "          transit.\r\n"
					+ "          <br /><br />\r\n"
					+ "          With our \"Standard International\" shipping option, your cards will be\r\n"
					+ "          shipped in a tracked letter for added peace of mind.<br /><br />\r\n"
					+ "          If you prefer a different shipping method or have any questions about\r\n"
					+ "          our shipping policies, please feel free to message us.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Card Condition</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          Please note that the product images may not be an exact representation\r\n"
					+ "          of the card you will receive. However, the card condition will always\r\n"
					+ "          match the stated details.\r\n"
					+ "          <br /><br />\r\n"
					+ "          If you have any questions about the stated grading or the condition of\r\n"
					+ "          a specific card, please don't hesitate to message us for more\r\n"
					+ "          information.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "";
		}
		else {
			outputString = outputString + "</p>"
					+ "</div>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Shipping Info</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          All cards are shipped safely to ensure their protection during\r\n"
					+ "          transit.\r\n"
					+ "          <br /><br />\r\n"
					+ "          With our \"Standard International\" shipping option, your cards will be\r\n"
					+ "          shipped in a tracked letter for added peace of mind.<br /><br />\r\n"
					+ "          If you prefer a different shipping method or have any questions about\r\n"
					+ "          our shipping policies, please feel free to message us.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Card Condition</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          Please note that the product images may not be an exact representation\r\n"
					+ "          of the card you will receive. However, the card condition will always\r\n"
					+ "          match the stated details.\r\n"
					+ "          <br /><br />\r\n"
					+ "          If you have any questions about the stated grading or the condition of\r\n"
					+ "          a specific card, please don't hesitate to message us for more\r\n"
					+ "          information.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "";
		}
	
		return outputString;
	}

}