package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPathRustrike;

public class i49LearnRussianStrike extends AbstractDynamicCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i49LearnRussianStrike.class.getSimpleName());
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static String IMG = makeCardPathRustrike("i49LearnRussianStrike.png", "i49LearnRussianStrikeDuolingo.png");



    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;


    private static CardRarity RARITY = CardRarity.COMMON;
    private static CardTarget TARGET = CardTarget.ENEMY;
    private static CardType TYPE = CardType.ATTACK;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 2;
    private static int DAMAGE = 0;
    private static int UPGRADE_PLUS_DMG = 6;


    public i49LearnRussianStrike() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        if (Settings.language == Settings.GameLanguage.RUS)
            MushrooghtMod.loadJokeCardImage(this, "i49LearnRussianStrike.png");
        else
            MushrooghtMod.loadJokeCardImage(this, "i49LearnRussianStrikeDuolingo.png");
        
        baseDamage = DAMAGE;
        this.tags.add(AbstractCard.CardTags.STRIKE);
        

    }

    public static int countCards() {
        int count = 0;
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (isStrike(c))
                count++;
        }
        for (AbstractCard c : AbstractDungeon.player.drawPile.group) {
            if (isStrike(c))
                count++;
        }
        for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
            if (isStrike(c))
                count++;
        }
        return count;
    }

    public static boolean isStrike(AbstractCard c) {
        return c.hasTag(AbstractCard.CardTags.STRIKE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
    }

    public void calculateCardDamage(AbstractMonster mo) {
        int realBaseDamage = this.baseDamage;
        this.baseDamage += 3 * countCards();
        super.calculateCardDamage(mo);
        this.baseDamage = realBaseDamage;
        this.isDamageModified = (this.damage != this.baseDamage);
    }

    public void applyPowers() {
        int realBaseDamage = this.baseDamage;
        this.baseDamage += 3 * countCards();
        super.applyPowers();
        this.baseDamage = realBaseDamage;
        this.isDamageModified = (this.damage != this.baseDamage);
    }


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
            initializeDescription();
        }
    }
}
