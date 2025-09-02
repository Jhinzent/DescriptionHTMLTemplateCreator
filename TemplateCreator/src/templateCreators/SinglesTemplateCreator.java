package templateCreators;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import helpers.Card;

public class SinglesTemplateCreator {
	
	String playsetText = "";
	String nameText = "";
	String languageText = "";
	String conditionText = "";
	String expansionText = "";
	String editionText = "";
	String rarityText = "";
	String signedText = "";
	ArrayList<Card> relatedCardsText = new ArrayList<Card>();

	public SinglesTemplateCreator(String playsetText, String nameText,String languageText,String conditionText, String expansionText, String editionText, String rarityText, String signedText, ArrayList<Card> relatedCardsText) {

		this.playsetText = playsetText;
		this.nameText = nameText;
		this.languageText = languageText;
		this.conditionText = conditionText;
		this.editionText = editionText;
		this.expansionText = expansionText;
		this.rarityText = rarityText;
		this.signedText = signedText;
		this.relatedCardsText = relatedCardsText;
		
		String masterText = createString();
		
		try {
            // Create the file
            File file = new File("output/output.html");
            file.createNewFile();
            
            // Write to the file
            FileWriter writer = new FileWriter(file);
            writer.write(masterText);
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	private String createString() {
		String outputString = "";
		
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
				+ "      visibility: hidden;\r\n"
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
				+ "      color: white;\r\n"
				+ "      border: 2px solid rgb(0, 0, 0);\r\n"
				+ "      background-color: rgb(227, 227, 227);\r\n"
				+ "      min-width: 20px;\r\n"
				+ "\r\n"
				+ "      display: inline-block;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .raritySymbol {\r\n"
				+ "      padding: 2px;\r\n"
				+ "      border-style: solid;\r\n"
				+ "      border-color: rgb(102, 102, 102);\r\n"
				+ "      border-width: 1px;\r\n"
				+ "      border-radius: 2px;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    #descrRarityCR {\r\n"
				+ "      background-color: rgb(138, 138, 138);\r\n"
				+ "    }\r\n"
				+ "    #descrRaritySU {\r\n"
				+ "      background-color: rgb(255, 166, 0);\r\n"
				+ "    }\r\n"
				+ "    #descrRaritySER {\r\n"
				+ "      background-color: rgba(222, 40, 183, 0.762);\r\n"
				+ "    }\r\n"
				+ "    #descrRaritySP {\r\n"
				+ "      background-color: rgb(85, 53, 201);\r\n"
				+ "    }\r\n"
				+ "    /* */\r\n"
				+ "    #descrConditionNM {\r\n"
				+ "      background-color: rgb(61, 176, 87);\r\n"
				+ "    }\r\n"
				+ "    #descrConditionEX {\r\n"
				+ "      background-color: rgb(130, 137, 30);\r\n"
				+ "    }\r\n"
				+ "    #descrConditionGD {\r\n"
				+ "      background-color: rgb(255, 193, 7);\r\n"
				+ "    }\r\n"
				+ "    #descrConditionLP {\r\n"
				+ "      background-color: rgb(253, 139, 43);\r\n"
				+ "    }\r\n"
				+ "    #descrConditionPL {\r\n"
				+ "      background-color: rgb(229, 104, 116);\r\n"
				+ "    }\r\n"
				+ "    #descrConditionPO {\r\n"
				+ "      background-color: rgb(220, 53, 69);\r\n"
				+ "    }\r\n"
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
				+ "    /* */\r\n"
				+ "    .informationCategoryDiv {\r\n"
				+ "      background-color: rgb(238, 238, 238);\r\n"
				+ "      padding: 7px 12px 7px 12px;\r\n"
				+ "      width: 100px;\r\n"
				+ "      background: linear-gradient(\r\n"
				+ "        -135deg,\r\n"
				+ "        rgba(222, 40, 183, 0.762),\r\n"
				+ "        20px,\r\n"
				+ "        #f8f8f8 0\r\n"
				+ "      );\r\n"
				+ "      border-radius: 5px;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    #infoTable {\r\n"
				+ "      border-spacing: 0 15px;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .tableDataRightRow {\r\n"
				+ "      text-align: center;\r\n"
				+ "      width: 300px;\r\n"
				+ "      border-style: solid;\r\n"
				+ "      border-width: 0px 0px 3px 0px;\r\n"
				+ "      border-color: rgb(241, 241, 241);\r\n"
				+ "      border-radius: 3px;\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "  <!-- body ------------------------------------------------------------- -->\r\n"
				+ "  <div id=\"topBar\">\r\n"
				+ "    <div id=\"topBarColor\">\r\n"
				+ "      <div id=\"topBarLabelContainer\">\r\n"
				+ "        <b id=\"topBarLabel\">JHINZENT</b>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "    <h3 class=\"header\" id=\"deckCoreNameHeader\">NOVIS</h3>\r\n"
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
				+ "      <h3 id=\"cardListHeader\">";
		
		String playsetStringGerEng = "";
		switch (playsetText) {
			case "3x" : playsetStringGerEng = "3x ";
			break;
			case "1x" : playsetStringGerEng = "";
			break;
			default : playsetStringGerEng = "ERROR DID NOT RECOGNIZE PLAYSET STATUS";
			break;
		}
		
		outputString = outputString + playsetStringGerEng;
		
		String nameStringGerEng = nameText;
		if(nameStringGerEng.equals("")) {
			nameStringGerEng = "ERROR DID NOT RECOGNIZE NAME";
		}
		
		outputString = outputString + nameStringGerEng;
		
		outputString = outputString + "</h3>\r\n"
				+ "      <div id=\"variableDecrContainer\">\r\n"
				+ "        <div class=\"infoContainerMain\">\r\n"
				+ "          <h3 class=\"infoHeader\">Karten Informationen</h3>\r\n"
				+ "          <div class=\"infoContent\">\r\n"
				+ "            <table id=\"infoTable\">\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Sprache</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		String languageStringGer = "";
		
		switch (languageText) {
			case "English" : languageStringGer = "Englisch";
			break;
			case "German" : languageStringGer = "Deutsch";
			break;
			case "Korean" : languageStringGer = "Koreanisch";
			break;
			case "Japanese" : languageStringGer = "Japanisch";
			break;
			default : languageStringGer = "ERROR DID NOT RECOGNIZE LANGUAGE";
			break;
		}
		
		outputString = outputString + languageStringGer;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Kartenzustand</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		String conditionStringGerEng = conditionText;
		if(conditionStringGerEng.equals("")) {
			conditionStringGerEng = "ERROR DID NOT RECOGNIZE CONDITION";
		}
		
		outputString = outputString + conditionStringGerEng;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Erweiterung</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		String expansionStringGerEng = expansionText;
		if(expansionStringGerEng.equals("")) {
			expansionStringGerEng = "ERROR DID NOT RECOGNIZE EXPANSION";
		}
		
		outputString = outputString + expansionStringGerEng;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Edition</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		String editionStringGer = "";
			switch (editionText) {
			case "1st Edition" : editionStringGer = "1. Auflage";
			break;
			case "Unlimited" : editionStringGer = "Unlimitiert";
			break;
			case "Limited Edition" : editionStringGer = "Limitierte Auflage";
			break;
			default : editionStringGer = "ERROR DID NOT RECOGNIZE EDITION";
			break;
		}
			
		outputString = outputString + editionStringGer;
		
		outputString = outputString + "</text>\r\n"
				+ "                  <!-- Unlimitiert, Limitierte -->\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Seltenheit</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		String rarityStringGerEng = rarityText;
		if(rarityStringGerEng.equals("")) {
			rarityStringGerEng = "ERROR DID NOT RECOGNIZE RARITY";
		}
		
		outputString = outputString + rarityStringGerEng;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "                <!-- Secret, Super, Common, Ultimate,\r\n"
				+ "                Gold, Collectors -->\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Signed / Altered</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		String signedStringGer = "";
			switch (signedText) {
			case "Yes" : signedStringGer = "Ja";
			break;
			case "No" : signedStringGer = "Nein";
			break;
			default : signedStringGer = "ERROR DID NOT RECOGNIZE SIGNED STATUS";
			break;
		}
			
		outputString = outputString + signedStringGer;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "            </table>\r\n"
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
		
		ArrayList<Card> filteredRelatedText = relatedCardsText;
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
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Versandinformationen</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          Alle Karten werden sicher in Toploadern verschickt, um während des\r\n"
					+ "          Transports geschützt zu sein.\r\n"
					+ "          <br /><br />\r\n"
					+ "          Mit unserer Versandoption \"Standard International\" werden Ihre Karten\r\n"
					+ "          in einem Brief mit Sendungsverfolgung verschickt, um Ihnen zusätzliche\r\n"
					+ "          Sicherheit zu geben.<br />\r\n"
					+ "          Wählen Sie die \"Economy International\" Versandoption für ein Paket mit\r\n"
					+ "          Sendungsverfolgung. <br /><br />Wenn Sie eine andere Versandmethode bevorzugen\r\n"
					+ "          oder Fragen zu unseren Versandrichtlinien haben, können Sie uns gerne\r\n"
					+ "          eine Nachricht senden.\r\n"
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
					+ "  <div id=\"descContainerEng\">\r\n"
					+ "    <div id=\"cardListConainer\">\r\n"
					+ "      <h3 class=\"header\" id=\"cardListHeader\">";
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
					+ "          Sicherheit zu geben.<br />\r\n"
					+ "          Wählen Sie die \"Economy International\" Versandoption für ein Paket mit\r\n"
					+ "          Sendungsverfolgung. <br /><br />Wenn Sie eine andere Versandmethode bevorzugen\r\n"
					+ "          oder Fragen zu unseren Versandrichtlinien haben, können Sie uns gerne\r\n"
					+ "          eine Nachricht senden.\r\n"
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
					+ "  <div id=\"descContainerEng\">\r\n"
					+ "    <div id=\"cardListConainer\">\r\n"
					+ "      <h3 class=\"header\" id=\"cardListHeader\">";
		}
		
		outputString = outputString + playsetStringGerEng;
		
		outputString = outputString + nameStringGerEng;
		
		outputString = outputString + "</h3>\r\n"
				+ "      <div id=\"variableDecrContainer\">\r\n"
				+ "        <div class=\"infoContainerMain\">\r\n"
				+ "          <h3 class=\"infoHeader\">Card Information</h3>\r\n"
				+ "          <div class=\"infoContent\">\r\n"
				+ "            <table id=\"infoTable\">\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Language</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		String languageStringEng = languageText;
		if(languageStringEng.equals("")) {
			languageStringEng = "ERROR DID NOT RECOGNIZE LANGUAGE";
		}
		
		outputString = outputString + languageStringEng;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "                <!-- German, Japanese, Korean -->\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Condition</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		outputString = outputString + conditionStringGerEng;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "                <!-- Near Mint, Good, Light Played,\r\n"
				+ "                Poor -->\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Expansion</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		outputString = outputString + expansionStringGerEng;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Edition</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		String editionStringEng = editionText;
		if(editionStringEng.equals("")) {
			editionStringEng = "ERROR DID NOT RECOGNIZE EDITION";
		}
		
		outputString = outputString + editionStringEng;
		
		outputString = outputString + "</text>\r\n"
				+ "                  <!-- Unlimited, Limited -->\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Rarity</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		outputString = outputString + rarityStringGerEng;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "                <!-- Secret, Super, Common, Ultimate,\r\n"
				+ "                Gold, Collectors -->\r\n"
				+ "              </tr>\r\n"
				+ "              <tr>\r\n"
				+ "                <td>\r\n"
				+ "                  <div class=\"informationCategoryDiv\">\r\n"
				+ "                    <text>Signed / Altered</text>\r\n"
				+ "                  </div>\r\n"
				+ "                </td>\r\n"
				+ "                <td class=\"tableDataRightRow\">\r\n"
				+ "                  <text>";
		
		String signedStringEng = signedText;
		if(signedStringEng.equals("")) {
			signedStringEng = "ERROR DID NOT RECOGNIZE SIGNED STATUS";
		}
		
		outputString = outputString + signedStringEng;
		
		outputString = outputString + "</text>\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "            </table>\r\n"
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
					+ "          All cards are shipped safely in toploaders to ensure their protection\r\n"
					+ "          during transit.\r\n"
					+ "          <br /><br />\r\n"
					+ "          With our \"Standard International\" shipping option, your cards will be\r\n"
					+ "          shipped in a tracked letter for added peace of mind.<br />\r\n"
					+ "          Choose the \"Economy International\" option for a tracked parcel.\r\n"
					+ "          <br /><br />\r\n"
					+ "          If you prefer a different shipping method or have any questions about\r\n"
					+ "          our shipping policies, please feel free to message us.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Card Condition</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          Please note that the product images may not be an exact representation\r\n"
					+ "          of the card you will receive. <br />However, the card condition will\r\n"
					+ "          always match the stated details. <br /><br />\r\n"
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
					+ "          All cards are shipped safely in toploaders to ensure their protection\r\n"
					+ "          during transit.\r\n"
					+ "          <br /><br />\r\n"
					+ "          With our \"Standard International\" shipping option, your cards will be\r\n"
					+ "          shipped in a tracked letter for added peace of mind.<br />\r\n"
					+ "          Choose the \"Economy International\" option for a tracked parcel.\r\n"
					+ "          <br /><br />\r\n"
					+ "          If you prefer a different shipping method or have any questions about\r\n"
					+ "          our shipping policies, please feel free to message us.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"infoContainer\">\r\n"
					+ "        <h3 class=\"infoHeader\">Card Condition</h3>\r\n"
					+ "        <p class=\"infoContent\">\r\n"
					+ "          Please note that the product images may not be an exact representation\r\n"
					+ "          of the card you will receive. <br />However, the card condition will\r\n"
					+ "          always match the stated details. <br /><br />\r\n"
					+ "          If you have any questions about the stated grading or the condition of\r\n"
					+ "          a specific card, please don't hesitate to message us for more\r\n"
					+ "          information.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n";
		}
	
		return outputString;
	}

}
