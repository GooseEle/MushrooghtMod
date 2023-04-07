package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i2Defend extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i2Defend.class.getSimpleName());
    public static final String IMG = makeCardPath("i2Defend.png");



    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 1;
    private static final int BLOCK = 5;
    private static final int UPGRADE_PLUS_BLOCK = 3;





    public i2Defend() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseBlock = BLOCK;

        this.tags.add(CardTags.STARTER_DEFEND);
        MushrooghtMod.loadJokeCardImage(this, "i2Defend.png");
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, block));
    }


    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBlock(UPGRADE_PLUS_BLOCK);
            initializeDescription();
        }
    }
}
