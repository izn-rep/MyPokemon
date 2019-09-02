package com.example.mypokemon.model;

import com.example.mypokemon.R;

import java.util.ArrayList;

public class PokemonData {
    private static String[] pokemonNames = {
            "Blissey",
            "Kyogre",
            "Metagross",
            "Machamp",
            "Groudon",
            "Gengar",
            "Moltres",
            "Rayquaza",
            "Mewtwo",
            "Tyranitar"
    };

    private static String[] pokemonDetails = {
            "Most of this list so far has been about attack and defense stats. That makes sense! They determine damage calculation and are therefore particularly important in PVP and Raid Battles. However, there is another stat in Pokemon Go which can be equally as important as the other two: stamina.",
            "Kyogre is similar to Groudon in that its attack and defense stats are exactly the same. However, instead of a dual-Ground moveset, Kyogre is best given a dual-Water one to capitalize on its typing.",
            "Metagross is another Pokemon viable both as an offensive and defensive pick. With 257 attack and 228 defense, you’ll want to make sure your Steel-type pseudo-Legendary has Bullet Punch as its Fast Move. Flash Cannon is also great for its Charged Attack. However, if you managed to get a Metagross with Meteor Mash during the Beldum Community Day, that’s even better.",
            "Fighting types are often forgotten about in the world of Pokemon, but Pokemon Go has quite a few formidable fighters hanging around the big leagues at present. Despite the valiant effort of Hariyama and Breloom (who is actually better as a Grass attacker given the recent addition of Grass Knot) — Machamp comes out on top.",
            "Groudon is a particularly strong Pokemon since both its attack and defense stats are huge. With a devastating 270 attack, coupled with the bulk of 228 base defense, Groudon is strong both as an attacker and a defender. That means it can both take and hold Gyms with relative ease.",
            "Gengar has always been a solid choice throughout the entire Pokemon series. In Pokemon Go, this is no different. A Gengar with dual-Ghost moves can take down Psychic and Ghost types with ease using its massive attack stat of 261. Ideally, you want both Hex and Shadow Ball for your Gengar.",
            "Moltres has never enjoyed much time in the meta of mainline Pokemon games, but proves to be quite a strong attacker in the mobile game. With access to a STAB Fire Spin/Overheat combo, Moltres supersedes even Charizard in terms of tier ranking in Pokemon Go.",
            "The Sky High Pokemon, Rayquaza, is an incredibly powerful Dragon/Flying hybrid that originated in the Gen 3 Pokemon games. In Pokemon Go, Rayquaza has a massive attack stat of 284, making it the most powerful dragon in the game. With myriad pseudo-Legendary dragons like Salamence and Dragonite being commonplace in the Pokemon Go meta, Rayquaza is just the anti-Dragon counter your team needs.",
            "Mewtwo’s monstrous 300 attack is second only to Deoxys. Although you might argue Mewtwo is still superior to the DNA Pokemon. Mewtwo’s Confusion/Psychic moveset also allows it to deal incredibly high DPS — gaining STAB from both its Fast Move and Charged Attack.",
            "The Dark/Rock-type pseudo-Legendary has been a fan-favorite ever since its introduction in Gen 2’s Johto region. Boasting an attack stat of 251, alongside considerable bulk and a strong typing (once you watch out for Fighting types, that is) Tyranitar is one of the strongest picks in the game."
    };

    private static int[] pokemonImages = {
            R.drawable.blissey,
            R.drawable.kyogre,
            R.drawable.metagross,
            R.drawable.machamp,
            R.drawable.groudon,
            R.drawable.gengar,
            R.drawable.moltres,
            R.drawable.rayquaza,
            R.drawable.mewtwo,
            R.drawable.tyranitar
    };

    public static ArrayList<Pokemon> getListData(){
        ArrayList<Pokemon> list = new ArrayList<>();
        for (int position = 0; position < pokemonNames.length; position++){
            Pokemon pokemon = new Pokemon();
            pokemon.setName(pokemonNames[position]);
            pokemon.setDetail(pokemonDetails[position]);
            pokemon.setPhoto(pokemonImages[position]);
            list.add(pokemon);
        }
        return list;
    };
}
