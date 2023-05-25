package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i6MyceliumPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i19Inviolable extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i19Inviolable.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillUncommon.png");


    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 0;

    private static final int MYCELIUM = 9;
    private static final int UPGRADE_PLUS_MYCELIUM = 4;

    // /STAT DECLARATION/

    public i19Inviolable() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        this.exhaust = true;
        this.isInnate = true;
        magicNumber = baseMagicNumber = MYCELIUM;
        MushrooghtMod.loadJokeCardImage(this, ".png");
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new i6MyceliumPower(p, p, this.magicNumber), this.magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_MYCELIUM);
            this.initializeDescription();
        }
    }

}
