package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;
import theMushrooght.powers.i15PutridHeartPower;

import static theMushrooght.MushrooghtMod.makeCardPath;
public class i76PutridHeart extends AbstractDynamicCard {

    public static String ID = theMushrooght.MushrooghtMod.makeID(i76PutridHeart.class.getSimpleName());
    public static String IMG = makeCardPath("i76PutridHeart.png");
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.POWER;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;
    private static int COST = 0;
    public i76PutridHeart() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i76PutridHeart.png");
        
        this.cardsToPreview = new i81BizarreParasite();

    }
    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        new ApplyPowerAction(p, p, new i15PutridHeartPower(p, 1), 1);
    }
    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.isInnate = true;
            this.rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
    public AbstractCard makeCopy() {
        return new i76PutridHeart();
    }
}
