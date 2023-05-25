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
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i31MonotropoidMycorrhiza extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i31MonotropoidMycorrhiza.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillRare.png");

    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;


    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = -2;


    // /STAT DECLARATION/

    public i31MonotropoidMycorrhiza() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
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