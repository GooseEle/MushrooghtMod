package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;
import theMushrooght.powers.i12MonDexterityPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i70Protocooperation extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i70Protocooperation.class.getSimpleName());
    public static String IMG = makeCardPath("i70Protocooperation.png");


    private static CardRarity RARITY = CardRarity.UNCOMMON;
    private static CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static CardType TYPE = CardType.POWER;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;
    private static int COST = 1;
    private static int COOPERATION = 2;
    private static int UPGRADE_PLUS_COOPERATION = 1;

    // /STAT DECLARATION/

    public i70Protocooperation() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "");
        
        magicNumber = baseMagicNumber = COOPERATION;

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, magicNumber), magicNumber));

      for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
          addToBot(new ApplyPowerAction(monster, p, new i12MonDexterityPower(monster, p, magicNumber), magicNumber));
      }
}

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_COOPERATION);
            this.initializeDescription();
        }
    }
}