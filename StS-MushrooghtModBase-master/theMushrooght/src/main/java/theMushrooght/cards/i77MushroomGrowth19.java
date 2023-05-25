package theMushrooght.cards;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.SadisticPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;
import theMushrooght.powers.i1SporePower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i77MushroomGrowth19 extends AbstractGrowthCard {

    public static String ID = theMushrooght.MushrooghtMod.makeID(i77MushroomGrowth19.class.getSimpleName());
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String IMG = makeCardPath("PowerRare.png");

    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;
    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.ALL;
    private static CardType TYPE = CardType.POWER;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;
    private static int COST = 1;
    private static int SADIST = 3;
    private static int UPGRADE_PLUS_SADIST = 2;

    public i77MushroomGrowth19() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "");
        
        magicNumber = baseMagicNumber = SADIST;

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new SadisticPower(p, this.magicNumber), this.magicNumber));

        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, p, new i1SporePower(monster, 3), 3));
                }
            }
        }

        AbstractCard c = AbstractGrowthCard.returnRandomGrowth();
        CardModifierManager.addModifier(c, new EtherealMod());
        addToBot(new MakeTempCardInHandAction(c, true));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_SADIST);
            initializeDescription();
        }
    }
}
