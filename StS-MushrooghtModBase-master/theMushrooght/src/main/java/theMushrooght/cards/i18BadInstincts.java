package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.actions.i6UnsafeBlockAction;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i3UnsafeBlockPower;
import theMushrooght.powers.i6MyceliumPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i18BadInstincts extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i18BadInstincts.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillUncommon.png");


    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 0;
    private static final int BAD_BLOCK = 10;
    private static final int UPGRADE_PLUS_BAD_BLOCK = 3;
    private static final int MYCELIUM = 3;


    public i18BadInstincts() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = BAD_BLOCK;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = MYCELIUM;
        this.isInnate = true;
        this.exhaust = true;
        MushrooghtMod.loadJokeCardImage(this, "i18BadInstincts.png");
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new i6UnsafeBlockAction(p));
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(p, p, new i3UnsafeBlockPower(p, magicNumber), magicNumber));

        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new i6MyceliumPower(p, p, this.defaultSecondMagicNumber), this.defaultSecondMagicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_BAD_BLOCK);
            initializeDescription();
        }
    }
}
