package theMushrooght.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;

public abstract class AbstractDynamicCard extends AbstractMushrooghtCard {
    public AbstractDynamicCard(String id, String img, int cost, AbstractCard.CardType type, AbstractCard.CardColor color, AbstractCard.CardRarity rarity, AbstractCard.CardTarget target) {
        super(id, (CardCrawlGame.languagePack.getCardStrings(id)).NAME, img, cost, (CardCrawlGame.languagePack.getCardStrings(id)).DESCRIPTION, type, color, rarity, target);
    }
}