package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i30Sclerotium extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i30Sclerotium.class.getSimpleName());
    public static String IMG = makeCardPath("i30Sclerotium.png");


    private static CardRarity RARITY = CardRarity.UNCOMMON;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 2;
    private static int ARTIFACT = 1;
    private static int BLOCK = 2;
    private static int UPGRADE_COST = 1;

    // /STAT DECLARATION/

    public i30Sclerotium() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i30Sclerotium.png");
        
        magicNumber = baseMagicNumber = ARTIFACT;
        baseBlock = BLOCK;
        this.exhaust = true;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new ArtifactPower(p, this.magicNumber), this.magicNumber));

    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            upgradeBaseCost(UPGRADE_COST);
            this.initializeDescription();
        }
    }
}