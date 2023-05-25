package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i31MonotropoidMycorrhiza extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i31MonotropoidMycorrhiza.class.getSimpleName());
    public static String IMG = makeCardPath("i31MonotropoidMycorrhiza.png");

    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;


    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.NONE;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = -2;


    // /STAT DECLARATION/

    public i31MonotropoidMycorrhiza() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i31MonotropoidMycorrhiza.png");
        
        this.cardsToPreview = new i26Endomycorrhiza();
        this.cardsToPreview = new i27Ectomycorrhiza();
    }

    public void triggerWhenDrawn() {
        addToTop(new ExhaustSpecificCardAction(this, AbstractDungeon.player.hand));
        addToBot(new MakeTempCardInHandAction(new i27Ectomycorrhiza(), 1));
        addToBot(new MakeTempCardInHandAction(new i26Endomycorrhiza(), 1));
        if (this.upgraded) {
            addToBot(new GainEnergyAction(1));
        }
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {}

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return false;
    }

    public void upgrade() {
        if (!this.upgraded) {
            rawDescription = UPGRADE_DESCRIPTION;
            upgradeName();
        }
    }

    public AbstractCard makeCopy() {
        return new i31MonotropoidMycorrhiza();
    }
}