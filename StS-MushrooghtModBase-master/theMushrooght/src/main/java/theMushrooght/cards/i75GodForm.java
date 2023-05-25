package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;
import theMushrooght.powers.i4GodFormPower;
import theMushrooght.powers.i5PaganismPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i75GodForm extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i75GodForm.class.getSimpleName());
    public static String IMG = makeCardPath("i75GodForm.png");
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;


    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.POWER;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 3;
    private static int GOD = 1;

    // /STAT DECLARATION/

    public i75GodForm() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i75GodForm.png");
        
        magicNumber = baseMagicNumber = GOD;
        this.isEthereal = true;
        this.cardsToPreview = new i80Bogue();
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new i4GodFormPower(p, this.magicNumber), this.magicNumber));
        addToBot(new ApplyPowerAction(p, p, new i5PaganismPower(p, 1), 1));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.isEthereal = false;
            this.rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }

    public AbstractCard makeCopy() {
        return new i75GodForm();
    }
}