
package com.mycompany.projetowallace;

import java.util.Random;
import java.util.Scanner;

public class JogoTextualKALAHARY {

    static void desafioFinal(int x, int w) {
        // FASE FINAL //
        System.out.println("\n*******");
        imprimir("Último Desafio");
        System.out.println("*******\n");

        String eFinal[][] = new String[3][3];
        //Ataques final personagem 0
        eFinal[0][0] = " Você acertou um tiro de pistola no peito do gorila!";
        eFinal[0][1] = " Você acertou um tiro de rifle no braço do gorila!";
        eFinal[0][2] = " Você fuzilou o gorila com uma metralhadora!";
        //Ataques final personagem 1
        eFinal[1][0] = " Você acertou um golpe com Facão!";
        eFinal[1][1] = " Na mosca, você pacertou uma flechada!";
        eFinal[1][2] = " Você acertou o gorila com um tiro de rifle!";
        //Ataques final personagem 2
        eFinal[2][0] = " Você jogou pó na cara do gorila!";
        eFinal[2][1] = " Você atirou um dardo no olho do gorila!";
        eFinal[2][2] = " Você comeu um belo marmitex!";

        // CHEFÂO //
        int hpUsuario = 200, hpPc = 200, especial = 1, bolsa = 3;
        boolean loopMenu = true;
        while (hpUsuario > 0) {

            while (hpUsuario > 0 && hpPc > 0) {

                imprimeHp(hpUsuario, hpPc, especial);

                int escolha = 0;
                switch (w) {
                    case 0 ->
                        escolha = ataquepersonagem1(x, bolsa);
                    case 1 ->
                        escolha = ataquepersonagem2(x, bolsa);
                    case 2 ->
                        escolha = ataquepersonagem3(x, bolsa);
                }

                switch (escolha) {

                    case 1 -> {
                        System.out.println("");
                        System.out.println(eFinal[w][0]);
                        hpPc -= 5;
                    }

                    case 2 -> {
                        System.out.println("");
                        System.out.println(eFinal[w][1]);
                        hpPc -= 10;
                    }

                    case 3 -> {

                        if (especial > 0) {
                            System.out.println("");
                            System.out.println(eFinal[w][2]);
                            if (w == 0) {
                                hpPc -= 20;
                            } else if (x == 3) {
                                hpPc -= 20;
                            } else {
                                hpUsuario += 75;
                            }
                            especial--;

                        } else {

                            System.out.println("Você esgotou seu ataque especial");
                            loopMenu = true;
                        }

                    }

                    default ->
                        System.out.println("Opção invalida!");

                }

                if (hpPc > 0) {

                    escolha = ataquePc();

                    switch (escolha) {

                        case 1 -> {
                            System.out.println("\n O gorila jogou cocos na sua cabeça!\n");
                            hpUsuario -= 5;
                        }

                        case 2 -> {
                            System.out.println("\n Gorila pulou em cima de você!\n");
                            hpUsuario -= 7;
                        }

                        case 3 -> {
                            System.out.println("\n Gorila deu uma voadora em você!\n");
                            hpUsuario -= 15;
                        }

                    }

                } else {

                    imprimir("\n***************");
                    imprimir(" Primo Alexandre, no final das contas, é reencontrado e a família pode retornar para casa! \n");
                    imprimir(" Mas, e outros parentes esquecidos e deixados na ilha Kalahari? \n");
                    imprimir(" Será a busca e resgate por parentes perdidos nesta ilha um preço pela ganância e conquista de tesouros pela Família Freitas? \n");
                    imprimir(" Nunca saberemos..... \n");
                    imprimir("*************\n");

                    creditos();

                }
            }
        }

    }

    static int ataquepersonagem1(int y, int z) {

        String[][] bolsa = new String[5][5];
        bolsa[0][0] = " Faca";
        bolsa[0][1] = " Revolver";
        bolsa[0][2] = " Rifle";
        bolsa[0][3] = " Metralhadora";
        bolsa[1][0] = " Soco";
        bolsa[1][1] = " Chute";
        bolsa[2][0] = " Pedra";
        bolsa[2][1] = " Pistola";
        bolsa[3][0] = " Empurrão";
        bolsa[3][1] = " Madeira";
        bolsa[4][0] = " Pistola";
        bolsa[4][1] = " Rifle";

        System.out.println("\nEscolha seu ataque:\n");
        System.out.println("(1) " + bolsa[y][0]);
        System.out.println("(2) " + bolsa[y][1]);
        System.out.println("(3) " + bolsa[0][z]);

        return numero();

    }

    static int ataquepersonagem2(int y, int z) {

        String[][] bolsa = new String[5][5];
        bolsa[0][0] = " Facão";
        bolsa[0][1] = " Lança";
        bolsa[0][2] = " Arco e flecha";
        bolsa[0][3] = " Rifle ";
        bolsa[1][0] = " Mão ";
        bolsa[1][1] = " Tocha ";
        bolsa[2][0] = " Chute";
        bolsa[2][1] = " Tocha";
        bolsa[3][0] = " Lança";
        bolsa[3][1] = " Faca";
        bolsa[4][0] = " Facão";
        bolsa[4][1] = " Arco e flecha";

        System.out.println("\nEscolha seu ataque:\n");
        System.out.println("(1) " + bolsa[y][0]);
        System.out.println("(2) " + bolsa[y][1]);
        System.out.println("(3) " + bolsa[0][z]);
        return numero();

    }

    static int ataquepersonagem3(int y, int z) {

        String[][] bolsa = new String[5][5];
        bolsa[0][0] = " Paçoca ";
        bolsa[0][1] = "Maçã";
        bolsa[0][2] = "Pão com Mortadela ";
        bolsa[0][3] = " Marmitex ";
        bolsa[1][0] = " Mochila ";
        bolsa[1][1] = " Chute ";
        bolsa[2][0] = " Soco";
        bolsa[2][1] = " Pedra";
        bolsa[3][0] = " Veneno";
        bolsa[3][1] = " Chute";
        bolsa[4][0] = " Pó";
        bolsa[4][1] = " Dardo";

        System.out.println("\nEscolha seu ataque:\n");
        System.out.println("(1) " + bolsa[y][0]);
        System.out.println("(2) " + bolsa[y][1]);
        System.out.println("(3) " + bolsa[0][z]);
        return numero();

    }

    static int ataquePc() {

        Random input = new Random();
        return input.nextInt(3) + 1;
    }

    static void imprimeHp(int hpUsuario, int hpPc, int especial) {

        System.out.println("______");
        System.out.println("");
        System.out.println("* HP USER: " + hpUsuario);
        System.out.println("* HP PC: " + hpPc);
        System.out.println("* ESPECIAL: " + especial + "/1");
        System.out.println("______");

    }

    static boolean menuDerrota() {

        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("");
        imprimir("Você foi derrotado!");
        System.out.println("");
        System.out.println("-------------------------------------");
        imprimir("(1) - Menu");
        imprimir("(2) - Sair");
        System.out.println("");

        int escolha = input.nextInt();

        boolean loop = true;

        switch (escolha) {

            case 1:

                loop = true;
                break;

            case 2:

                loop = false;
                break;

            default:

                System.out.println("Opção invalida, tente novamente!");
                loop = true;

        }

        return loop;
    }

    static boolean batalha1(String nome) {

        Scanner input = new Scanner(System.in);

        // FASE 1 //
        System.out.println("");
        System.out.println("--------------------------------------------------");
        imprimir("Com dor nas costas e na cabeça, Pedro reconhece que a ideia de saltar do avião antes da queda e usar dos galhos das árvores como amortecedores não foi uma má ideia. \n");
        imprimir("O que ele não esperava era de que os galhos não fossem tão resistentes quanto gostaria e acabasse por bater cabeça, peito e costas em vários galhos antes de cair no chão. \n");
        imprimir("Contudo, agradece por estar com sua faca e poder, então, se virar na floresta para sair da ilha e reencontrar o Primo Alexandre. \n");
        imprimir("No entanto, Pedro vê que não está sozinho, pois piratas Somalis festejam na praia entorno da fogueira. E decide por ir atrás de um pirata isolado para tomar sua pistola. \n");
        imprimir("Mas, sem querer, Pedro pisa e quebra um galho próximo do pirata, que o percebe e saca sua faca para matá-lo.\n ");
        System.out.println("--------------------------------------------------");
        imprimir("Seja bem vindo " + nome);

        // 1º BATALHA //
        int hpUsuario = 100, hpPc = 100, especial = 1;
        boolean loopMenu = true;

        while (hpUsuario > 0) {

            while (hpUsuario > 0 && hpPc > 0) {

                imprimeHp(hpUsuario, hpPc, especial);

                int escolha = ataquepersonagem1(1, 0);

                switch (escolha) {

                    case 1 -> {
                        System.out.println("");
                        System.out.println("Você deu um soco no queixo do pirata !");
                        hpPc -= 5;
                    }

                    case 2 -> {
                        System.out.println("");
                        System.out.println("Você deu um chute na barriga do pirata !");
                        hpPc -= 10;
                    }

                    case 3 -> {

                        if (especial > 0) {

                            System.out.println("");
                            imprimir("Você cortou o pirata com a sua faca !");
                            hpPc -= 20;
                            especial--;
                        } else {

                            System.out.println("Voce não tem mais especial");
                        }

                    }

                    default ->
                        System.out.println("Opção inválida!");

                }

                if (hpPc > 0) {

                    escolha = ataquePc();

                    switch (escolha) {

                        case 1:

                            System.out.println("");
                            System.out.println(" O pirata deu um soco no  seu nariz!");
                            System.out.println("");
                            hpUsuario -= 5;
                            break;

                        case 2:

                            System.out.println("");
                            System.out.println(" O pirata bateu em você com um porrete!");
                            System.out.println("");
                            hpUsuario -= 7;
                            break;

                        case 3:

                            System.out.println("");
                            imprimir(" O pirata atirou em você com uma pistola !");
                            System.out.println("");
                            hpUsuario -= 13;
                            break;

                    }

                } else {

                    imprimir(" O pirata caiu atordoado no chão! Você pegou sua pistola e se escondeu na mata. \n");
                    System.out.println("");

                    // FASE 2 //
                    imprimir("Armado com uma faca e uma pistola e certo de que os outros piratas não escutaram a briga, Pedro respira aliviado. \n");
                    imprimir("Mas, perdido e confuso para onde ir, Pedro observa o ambiente da ilha para decidir aonde ir. \n");
                    imprimir("E vê, então, um antigo farol abandonado na costa da ilha e decide ir até lá para ter uma visão ampla da ilha. \n");
                    imprimir("No entanto, percebe que, em seu encalço, vem um grupo de piratas enquanto atiram em sua direção e corre para o farol a fim de se proteger. \n");
                    imprimir(" E, enquanto avança rumo ao farol abandonado, Pedro segue atirando de volta para atrasar a perseguição dos piratas. \n");

                    // 2º BATALHA //
                    hpUsuario = 120;
                    hpPc = 150;
                    especial = 1;

                    while (hpUsuario > 0) {

                        while (hpUsuario > 0 && hpPc > 0) {

                            imprimeHp(hpUsuario, hpPc, especial);

                            escolha = ataquepersonagem1(2, 1);

                            switch (escolha) {

                                case 1 -> {
                                    System.out.println("");
                                    System.out.println("Você atirou uma pedra na direção dos piratas!");
                                    hpPc -= 15;
                                }

                                case 2 -> {
                                    System.out.println("");
                                    System.out.println("Você deu um tiro de pistola na direção dos piratas!");
                                    hpPc -= 20;
                                }

                                case 3 -> {

                                    if (especial > 0) {

                                        System.out.println("");
                                        imprimir("Você deu vários tiros em sequência nos piratas !");
                                        hpPc -= 40;
                                        especial--;
                                    } else {

                                        System.out.println("Voce não tem mais especial");
                                    }
                                }

                                default ->
                                    System.out.println("Opção inválida!");

                            }

                            if (hpPc > 0) {

                                escolha = ataquePc();

                                switch (escolha) {

                                    case 1 -> {
                                        System.out.println("");
                                        System.out.println(" Os piratas atiram flechas em você !");
                                        System.out.println("");
                                        hpUsuario -= 7;
                                    }

                                    case 2 -> {
                                        System.out.println("");
                                        System.out.println(" Os piratas dão tiros raspão em você !");
                                        System.out.println("");
                                        hpUsuario -= 10;
                                    }

                                    case 3 -> {
                                        System.out.println("");
                                        imprimir("Os piratas atiram com precisão em você !");
                                        System.out.println("");
                                        hpUsuario -= 16;
                                    }

                                }
                            } else {

                                imprimir("Pedro, então, conseque chegar ao farol e corre pelas escadarias para o último andar para se entrincheirar enquanto os piratas o perseguem. \n");
                                imprimir("E, durante a montagem sua barreira com os velhos móveis para dificultar a entrada dos piratas, Pedro descobre um velho rifle no armário de equipamentos. \n");
                                imprimir("Mas, com os  piratas derrubando sua barricada de proteção, Pedro decide rapidamente revidar e descarregar seu rifle nos piratas. \n");
                                System.out.println("");
                                // FASE 3 //
                                imprimir(" Agora, Pedro sabe consigo mesmo, é uma questão de vida ou morte e o sucesso de resgatar Alexandre depende de sua habilidade com armas.\n");
                                // 3° FASE //
                                hpUsuario = 130;
                                hpPc = 180;
                                especial = 1;

                                while (hpUsuario > 0) {

                                    while (hpUsuario > 0 && hpPc > 0) {

                                        imprimeHp(hpUsuario, hpPc, especial);

                                        escolha = ataquepersonagem1(3, 2);

                                        switch (escolha) {
                                            case 1:
                                                System.out.println("");
                                                System.out.println("Você empurrou um pirata por escada abaixo!");
                                                hpPc -= 25;

                                            case 2:
                                                System.out.println("");
                                                System.out.println("Você bateu com um pedaço de madeira no pirata!");
                                                hpPc -= 35;

                                            case 3:
                                                if (especial > 0) {
                                                    imprimir("Você atirou com seu rifle!");
                                                    hpPc -= 60;
                                                    especial--;
                                                } else {
                                                    System.out.println("Você não tem mais força para usar o especial!");
                                                }
                                                break;

                                            default:
                                                System.out.println("Opção invalida você errou o ataque!!");
                                        }
                                        if (hpPc > 0) {

                                            escolha = ataquePc();

                                            switch (escolha) {
                                                case 1:
                                                    System.out.println(" Pirata bate em você com um taco de beisebol !");
                                                    hpUsuario -= 15;

                                                case 2:

                                                    System.out.println(" Pirata lança uma faca em você !");
                                                    hpUsuario -= 20;

                                                case 3:

                                                    imprimir(" Pirata atira com pistola contra você !");
                                                    hpUsuario -= 25;

                                            }

                                        } else {
                                            System.out.println("--------------------------------------------------");
                                            imprimir(" Esgotado, Pedro percebe que, no final, conseguiu derrubar vários piratas e afastar o restante com estes fugindo em busca de reforços. \n");
                                            imprimir("Mas, sem demora, Pedro vê ao longe uma pista de pouso e uma torre de comando de tráfego aéreo.E, sem pensar muito, decide ir lá em busca de ajuda. \n");
                                            imprimir("No meio do caminho para o aeroporto, Pedro descobre uma carcaça de um avião da 2ª Guerra Mundial, e, em sua cabine, uma antiga metralhadora ainda funcional. \n");
                                            imprimir("E, seguindo para o aeroporto, Pedro identifica um gorila perseguindo um sujeito enquanto este se refugia na torre de comando. \n ");
                                            imprimir(" E percebe, então, é o Primo Alexandre e decide ir em seu socorro e lidar com o gorila... \n ");
                                            System.out.println("--------------------------------------------------\n");

                                            int personagem = 0;
                                            desafioFinal(4, personagem);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return menuDerrota();
    }

    static boolean batalha2(String nome) {

        // FASE 1 //
        System.out.println("\n--------------------------------------------------");
        imprimir("BEM VINDO AO JOGO " + nome);
        imprimir("No momento em que José saltou do avião antes da queda, a única coisa em que pensou foi em pular com os olhos fechados e torcer para cair em segurança. \n");
        imprimir("Com sorte, não se espatifou no chão, mas rolou diretamente por uma pequena gruta, o que, pelo menos, aliviou a força da queda. \n");
        imprimir("Assustado com a escuridão da caverna, José  acende um fósforo, pega um pedaço de madeira do chão e rasga a manga da jaqueta  para acender uma tocha. \n");
        imprimir("Contudo, o que não percebe é que, com  a luz da tocha acesa, um grupo de morcegos pendurados no teto se amendrontam  e um grande morcego o ataca. \n");
        System.out.println("--------------------------------------------------\n");

        // 1º BATALHA //
        int hpUsuario = 100, hpPc = 100, especial = 1;
        boolean loopMenu = true;

        while (hpUsuario > 0) {

            while (hpUsuario > 0 && hpPc > 0) {

                imprimeHp(hpUsuario, hpPc, especial);

                int escolha = ataquepersonagem2(1, 0);

                switch (escolha) {

                    case 1:

                        System.out.println("\n  Você deu um tapa no morcego !");
                        hpPc -= 10;
                        break;

                    case 2:

                        System.out.println("\n  Você bateu com a tocha acesa no morcego !");
                        hpPc -= 15;
                        break;

                    case 3:

                        if (especial > 0) {

                            System.out.println("");
                            imprimir("Você esfaqueou o morcego com o facão !");
                            hpPc -= 20;
                            especial--;
                        } else {

                            System.out.println("Voce nao tem mais especial");

                        }
                        break;
                    default:

                        System.out.println("Opção invalida, você perdeu sua vez!");

                }

                if (hpPc > 0) {

                    escolha = ataquePc();

                    switch (escolha) {

                        case 1:

                            System.out.println("\n O morcego mordeu o seu nariz !\n -05 hp");
                            hpUsuario -= 5;
                            break;

                        case 2:

                            System.out.println("\n O morcego cortou o seu rosto com as garras !\n -10 hp");
                            hpUsuario -= 10;
                            break;

                        case 3:

                            imprimir("\n  O morcego mordeu o seu pescoço !\n -15 hp");
                            hpUsuario -= 15;
                            break;

                    }

                } else {

                    System.out.println("--------------------------------------------------");
                    imprimir(" O morcego fugiu! Mas, sem perder tempo, José procura e encontra uma fissura na parede da caverna e escapa por lá. \n");
                    System.out.println("--------------------------------------------------\n");

                    // FASE 2 //
                    imprimir(" Mas, saindo da brecha, José deslumbra um lago interno da caverna iluminado pela luz do sol entrando por um  buraco no teto da caverna com uma cachoeira. \n.");
                    imprimir(" E se maravilha com a caverna marcada por escadas e estátuas de deuses antigos escavados em rocha. Porém, cansado e com sede, decide beber a água do lago. \n");
                    imprimir(" Enquanto descia as escadas, José aproveita e toma para si uma lança de ouro posta em uma estátua por precaução. \n");
                    imprimir(" Precaução correta, porque, durante o aliviar da sede no lago, uma lacraia desce pela parede atrás dele e, de prontidão, José saca a lança. \n ");

                    hpUsuario = 120;
                    hpPc = 150;
                    especial = 1;

                    while (hpUsuario > 0) {

                        while (hpUsuario > 0 && hpPc > 0) {

                            imprimeHp(hpUsuario, hpPc, especial);

                            escolha = ataquepersonagem2(2, 1);

                            switch (escolha) {

                                case 1:

                                    System.out.println("\n Voce deu um pontapé na lacraia !");
                                    hpPc -= 15;
                                    break;

                                case 2:

                                    System.out.println("\n  Você bateu com sua tocha na lacraia!");
                                    hpPc -= 25;
                                    break;

                                case 3:

                                    if (especial > 0) {

                                        System.out.println("");
                                        imprimir("Você perfurou a lacraia com a lança !");
                                        hpPc -= 40;
                                        especial--;
                                    } else {

                                        System.out.println("Voce não tem mais especial");
                                    }
                                    break;

                                default:

                                    System.out.println("Opção inválida, você perdeu sua vez!");

                            }

                            if (hpPc > 0) {

                                escolha = ataquePc();

                                switch (escolha) {

                                    case 1:

                                        System.out.println("\n Lacria pula em você e te derruba \n -10 hp");
                                        hpUsuario -= 10;
                                        break;

                                    case 2:

                                        System.out.println("\n Lacria se enrola em você e espreme seus ossos !\n -15 hp");
                                        System.out.println("");
                                        hpUsuario -= 14;
                                        break;

                                    case 3:

                                        imprimir("\n Lacraia te morde com suas mandíbulas !\n -20 hp");
                                        hpUsuario -= 18;
                                        break;

                                }
                            } else {

                                System.out.println("--------------------------------------------------");
                                imprimir(" Depois de uma luta intensa e difícil, José consegue matar a lacraia. \n");
                                imprimir(" E, ao se virar para sentar e descansar, José vê uma multidão de anões, um povo do mundo subterrâneo. \n");
                                imprimir("Então, um anão mais forte e, aparentando, ser o líder, toma a frente e se direciona a José e o entrega um arco e flecha como presente. \n");
                                imprimir("E se porta em reverência e em agradecimento pela execução da lacraia. Em resposta, José repete a postura e se prepara para seguir em frente. \n");
                                System.out.println("--------------------------------------------------\n");

                                // FASE 3 //
                                imprimir("Armado com uma faca, lança e arco e flecha, José observa com atenção a região do lago para achar uma saída. \n");
                                imprimir("E percebe que, em uma ponta do lago, escoa um pequeno riacho para fora da caverna. E decide seguí-lo. \n");
                                imprimir("E, ao seguir pelo riacho, José encontra uma saída desaguando no oceano em uma pequena praia frente a saída da caverna. \n");
                                imprimir("Mas, ao sair da caverna, se depara com um acampamento de piratas Somalis e, sorrateiramente, decide eliminá-los com seu arco e flecha. \n ");
                                imprimir("Contudo, ao acertar um pirata, este grita de dor e um pirata localiza José e o ataca. \n ");

                                hpUsuario = 130;
                                hpPc = 180;
                                especial = 1;

                                while (hpUsuario > 0) {

                                    while (hpUsuario > 0 && hpPc > 0) {

                                        imprimeHp(hpUsuario, hpPc, especial);

                                        escolha = ataquepersonagem2(3, 2);

                                        switch (escolha) {

                                            case 1:

                                                System.out.println("\n Você deu uma facada no pirata !");
                                                hpPc -= 25;
                                                break;

                                            case 2:

                                                System.out.println("\n Você perfurou o pirata com a lança !");
                                                hpPc -= 35;
                                                break;

                                            case 3:

                                                if (especial > 0) {

                                                    System.out.println("");
                                                    imprimir("Você flechou o pirata ! ");
                                                    hpPc -= 60;
                                                    especial--;
                                                } else {

                                                    System.out.println("Voce nao tem mais especial");
                                                }
                                                break;

                                            default:

                                                System.out.println("Opção invalida, você perdeu a vez!");

                                        }

                                        if (hpPc > 0) {

                                            escolha = ataquePc();

                                            switch (escolha) {

                                                case 1:

                                                    System.out.println("\n O pirata arremessa a faca em você ! \n -15 hp");
                                                    hpUsuario -= 15;
                                                    break;

                                                case 2:

                                                    System.out.println("\n O pirata te acerta com um porrete !\n -20 hp");
                                                    System.out.println("");
                                                    hpUsuario -= 20;
                                                    break;

                                                case 3:

                                                    imprimir("\n  O pirata atira com um revólver em você !\n -25 hp");
                                                    hpUsuario -= 25;
                                                    break;

                                            }
                                        } else {
                                            System.out.println("--------------------------------------------------");
                                            imprimir("Com o último pirata morto, José pega um rifle do baú de armas para se defender melhor. \n");
                                            imprimir("Mas, desorientado quanto a onde ir e retomar a busca por Primo Alexandre, José avalia o terreno ao redor. \n ");
                                            imprimir("Com isso, vê a foz de um rio, e conclui que o rio nasce em um ponto mais alto e com melhor vista da região para localização.\n");
                                            imprimir("E, seguindo rio acima, José encontra um posto de abastecimento de água de um aeroporto e vai a este em busca de informações.\n");
                                            imprimir("Mas, ao chegar lá, vê Primo Alexandre fugindo para um galpão com um gorila o perseguindo.E decide encarar o gorila e resgatar seu primo.\n");

                                            System.out.println("--------------------------------------------------\n");

                                            int personagem = 1;
                                            desafioFinal(4, personagem);
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return menuDerrota();
    }

    static boolean batalha3(String nome) {

        // FASE 1 //
        System.out.println("\n--------------------------------------------------");
        imprimir(" Bem Vindo ao Jogo! " + nome);
        imprimir(" Atordoada pela queda da avião, Marina recupera a consciência e se pergunta como sobreviveu, onde estão seus irmãos Pedro e José e se estão bem. \n");
        imprimir(" Mas, vendo-se sozinha em meio a mata fechada da ilha de Kalahari, Marina lembra de que, tão importante quanto a sobrevivência e sair da ilha, é encontrar Primo Alexandre. \n");
        imprimir(" E, apesar de perdida, vê o pico de um monte no horizonte e decide seguir para lá para se localizar melhor e ir investigando onde está seu parente. \n");
        imprimir(" Mas, não ela esperava que, nem os machucados da queda se curariam, ela encontraria um Dragão-de-Komodo rastejando rapidamente na sua direção com sangue nos olhos. \n");

        // 1º BATALHA //
        int hpUsuario = 100, hpPc = 100, especial = 1;
        boolean loopMenu = true;

        while (hpUsuario > 0) {

            while (hpUsuario > 0 && hpPc > 0) {

                imprimeHp(hpUsuario, hpPc, especial);

                int escolha = ataquepersonagem3(1, 0);

                switch (escolha) {

                    case 1:

                        System.out.println("\n  Você bateu com a sua mochila nele!");
                        hpPc -= 10;
                        break;

                    case 2:

                        System.out.println("\n  Você deu uma bica nele!");
                        hpPc -= 15;
                        break;

                    case 3:

                        imprimir("\n  Você comeu uma paçoca!");
                        hpUsuario += 25;
                        especial--;
                        break;

                    default:

                        System.out.println("Opção invalida!");

                }

                if (hpPc > 0) {

                    escolha = ataquePc();

                    switch (escolha) {

                        case 1:

                            System.out.println("\n Dragão-de-Komodo mordeu a sua canela! \n Você perdeu 5 de vida");
                            hpUsuario -= 5;
                            break;

                        case 2:

                            System.out.println("\n Dragão-de-Komodo bateu com a cauda na sua cara !\n Você perdeu 10 de vida");
                            hpUsuario -= 10;
                            break;

                        case 3:

                            imprimir("\n Dragão-de-Komodo cuspiu ácido em você !\n Você perdeu 15  de vida");
                            hpUsuario -= 15;
                            break;

                    }

                } else {

                    System.out.println("--------------------------------------------------");
                    imprimir("Dragão-de-Komodo foi derrotado! Fugiu e se escondeu na mata!");
                    imprimir(" É hora de seguir em frente com a busca...");
                    System.out.println("--------------------------------------------------\n");

                    // FASE 2 //
                    imprimir(" Aliviada com a fuga do Dragão-de-Komodo, Marina decide por seguir com sua jornada rumo ao monte. \n");
                    imprimir(" Chegando ao monte, Marina observa uma aldeia de nativos da ilha e decide por ir buscar informações com eles e descobrir como escapar da ilha e se viram seus irmãos e primo. \n");
                    imprimir(" No entanto, ao chegar lá e tentar o primeiro contato, Marina se vê cercada por nativos hostis e com lanças apontadas para ela. \n");
                    imprimir(" Marina decide por, então, correr e se esconder em uma tenda. Mas, é encontrada por um nativo e é forçada a lutar novamente. \n");

                    // 2º BATALHA //
                    hpUsuario = 120;
                    hpPc = 150;
                    especial = 1;

                    while (hpUsuario > 0) {

                        while (hpUsuario > 0 && hpPc > 0) {

                            imprimeHp(hpUsuario, hpPc, especial);

                            escolha = ataquepersonagem3(2, 1);

                            switch (escolha) {

                                case 1:

                                    System.out.println("\n Você deu um soco na cara dele! ");
                                    hpPc -= 10;
                                    break;

                                case 2:

                                    System.out.println("\n Você jogou uma pedra nele. ");
                                    hpPc -= 25;
                                    break;

                                case 3:

                                    imprimir("\n  Você  comeu uma maçã !");
                                    hpUsuario += 50;
                                    especial--;
                                    break;

                                default:

                                    System.out.println("Opção invalida!");

                            }

                            if (hpPc > 0) {

                                escolha = ataquePc();

                                switch (escolha) {

                                    case 1:

                                        System.out.println("\n O nativo bateu com a lança na sua cabeça !\n -10 hp");
                                        hpUsuario -= 10;
                                        break;

                                    case 2:

                                        System.out.println("\n O nativo corta sua pele com a lança!\n -15 hp");
                                        System.out.println("");
                                        hpUsuario -= 15;
                                        break;

                                    case 3:

                                        imprimir("\n O nativo atira uma flecha em você!\n -20 hp");
                                        hpUsuario -= 20;
                                        break;

                                }
                            } else {

                                System.out.println("--------------------------------------------------");
                                imprimir("Nativo derrotado! E você descobriu lanches na mochila para se revigorar!");
                                imprimir("Mas a saga ainda não acabou...");
                                System.out.println("--------------------------------------------------\n");

                                // FASE 3 //
                                imprimir("Enquanto fugia da aldeia e se afastava dos nativos, Marina descobriu uma torre de rádio abandonada.\n ");
                                imprimir(" A torre, apesar de abandonada, demonstrava usos recentes de seus rádios e blocos de notas.\n");
                                imprimir(" Com isso, Marina consegue entrar em contato com uma plataforma petrolífera australiana próxima e descobre que há uma pista de pouso ao norte da ilha. \n");
                                imprimir(" E, ao revirar os registros nos blocos de notas do rádio, Marina descobre que, seu Primo Alexandre, passou por lá e anotou que escaparia para o aeroporto. \n ");
                                imprimir("Com isso, e sem perder tempo, Marina sai em direção ao norte da ilha. Mas ignora o fato de ter anoitecido \n ");
                                imprimir("E, na ânsia de ir embora, não percebe quando uma pantena negra salta diante dela ávida por carne fresca...");

                                // 3º BATALHA //
                                hpUsuario = 130;
                                hpPc = 180;
                                especial = 1;

                                while (hpUsuario > 0) {

                                    while (hpUsuario > 0 && hpPc > 0) {

                                        imprimeHp(hpUsuario, hpPc, especial);

                                        escolha = ataquepersonagem3(3, 2);

                                        switch (escolha) {

                                            case 1:

                                                System.out.println("\n Você jogou veneno de plantas na cara dela !");
                                                hpPc -= 25;
                                                break;

                                            case 2:

                                                System.out.println("\n  Você chutou a cara dela!");
                                                hpPc -= 35;
                                                break;

                                            case 3:

                                                imprimir("\n Você comeu de um pão com mortadela");
                                                hpUsuario += 75;
                                                especial--;
                                                break;

                                            default:

                                                System.out.println("Opção invalida!");

                                        }

                                        if (hpPc > 0) {

                                            escolha = ataquePc();

                                            switch (escolha) {

                                                case 1:

                                                    System.out.println("\n A Pantera pulou em cima e te derrubou! \n -15 hp");
                                                    hpUsuario -= 15;
                                                    break;

                                                case 2:

                                                    System.out.println("\n A pantera te cortou com as unhas afiadas\n -20 hp");
                                                    System.out.println("");
                                                    hpUsuario -= 20;
                                                    break;

                                                case 3:

                                                    imprimir("\n A pantera mordeu seu braço!\n -25 hp");
                                                    hpUsuario -= 25;
                                                    break;

                                            }
                                        } else {
                                            System.out.println("--------------------------------------------------");
                                            imprimir("Ufa! A pantera fugiu e se escondeu! Agora, está livre para seguir em frente. \n");
                                            imprimir("E ao  seguir e chegar ao aeroporto, Marina vê seu Primo Alexandre correndo e se escondendo em uma guarita do aeroporto enquanto um gorila nervoso o persegue.");
                                            imprimir("E sabe que, então, para escapar da ilha e resgatar seu primo, não tem escolha, se não, confrontar o gorila.");
                                            System.out.println("--------------------------------------------------\n");

                                            int personagem = 2;
                                            desafioFinal(4, personagem);
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return menuDerrota();
    }

    static boolean instruções() {

        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("INSTRUÇõES: olá, jogador(a). Neste jogo de RPG em formato textual, você irá explorar uma aventura de uma família de aventureiros em busca de um parente e tesouro perdido. \n");
        System.out.println("Nome e Classe: como primeiro passo, antes de jogar, é necessário que você selecione o nome como deseja ser chamado e a classe do personagem.\n");
        System.out.println("Classes: neste jogo, temos três classes - (1) Caçador; (2)  Explorador; e (3) Bióloga. Cada classe tem um conjunto de ataques e um especial único. \n ");
        System.out.println("Caminhos: cada personagem e classe, neste jogo, terá um caminho exclusivo com inimigos e combates próprios para enfrentar ao longo da sua jornada. \n");
        System.out.println("Evolução: a cada desafio e inimigo superado, a habilidade única será aprimorada para uma versão melhor e mais forte para encarar os próximos embates. \n ");
        System.out.println("Desafio Final: por fim, para concluir a narrativa, você será confrontado com um inimigo final a ser derrotado e conhecer o final da história. \n ");

        System.out.println("(1) - Menu");
        System.out.println("(2) - Sair");
        System.out.println("");

        int escolha = input.nextInt();

        boolean loop = true;

        switch (escolha) {

            case 1:

                loop = true;
                break;

            case 2:

                loop = false;
                break;

            default:

                System.out.println("Opção invalida, tente novamente!");
                break;

        }
        return loop;
    }
 
    static boolean creditos() {

        Scanner input = new Scanner(System.in);

        System.out.println("");
        imprimir("Muito obrigado por jogar nosso jogo KALAHARY.\n");
        imprimir(" Desenvolvedores: Leilane Nascimento\n");
        imprimir(" Desenvolvedores: Luan Silva\n");
        imprimir(" Desenvolvedores: Rafael de Souza\n");
        imprimir(" Desenvolvedores: Semaías Lima\n");
        imprimir(" Desenvolvedores: Uriel Perrucho\n");
        imprimir(" Desenvolvedores: Wallace Wagner\n");
        imprimir("Até a próxima aventura! \n");
        System.out.println("");
        System.out.println("(1) - Menu");
        System.out.println("(2) - Sair");
        System.out.println("");

        int escolha = input.nextInt();

        boolean loop = true;

        switch (escolha) {

            case 1:

                menuInicial();
                break;

            case 2:

                loop = false;
                break;

            default:

                System.out.println("Opção invalida, tente novamente!");
                break;

        }
        return loop;
    }

    static int escolhaClasse() {

        int classe = 0;

        System.out.println("\n--------------------------------------------------");
        imprimir("Antes de começar, selecione uma das classes abaixo:");
        System.out.println("--------------------------------------------------\n");
        imprimir("(1) - Caçador");
        imprimir("(2) - Explorador");
        imprimir("(3) - Bióloga");
        System.out.println();
        int escolha = numero();

        switch (escolha) {

            case 1:

                System.out.println("\n--------------------------------------------------");
                imprimir("        Você escolheu o caçador, vamos lá!");
                System.out.println("--------------------------------------------------\n");
                classe = 1;
                break;

            case 2:

                System.out.println("\n--------------------------------------------------");
                imprimir("      Você escolheu o explorador, vamos lá!");
                System.out.println("--------------------------------------------------\n");
                classe = 2;
                break;

            case 3:

                System.out.println("\n--------------------------------------------------");
                imprimir("        Você escolheu a bióloga , vamos lá !");
                System.out.println("--------------------------------------------------\n");
                classe = 3;
                break;

        }
        return classe;
    }

    static void introdução() {

        System.out.println();
        System.out.println("Digite N para a Introdução do jogo");
        System.out.println("Ou digite J para começar o jogo");
        String n = texto();
        n = n.toUpperCase();
        if (n.equals("N")) {
            //Aqui é a introdução que pode ser pulada 
            imprimir(" Diário: 10-09-21. O que parece apenas um jogo para outras pessoas, é uma tradição para a família Freitas. Nós caçamos tesouros antigos de povos esquecidos pela humanidade como os Astecas e Incas.\n");
            imprimir("Mas, desta vez, as coisas deram errado. Nossas pesquisas revelaram uma ilha no Oceano Pacífico crentes de que, lá, encontraríamos um grande tesouro Maori. \n");
            imprimir("Primo Alexandre, destemido como era, não perdeu tempo, e partiu do Porto de Santos rumo a ilha chamada pelos cadernos de pesquisa como: 'Kalahari'. \n ");
            imprimir("Mas, com três meses sem notícias de Primo Alexandre, nossa família começou a se preocupar com seu desaparecimento. \n");
            imprimir("E, com isto, eu, Marina Freitas, bióloga pela Universidade de Campinas. Pedro Freitas, atirador profissional em olímpiadas e José, explorador de povos antigos, decidimos resgatar Primo Alexandre.  \n");

        }

        imprimir("Após viajar a Nova Zelândia, Marina, Pedro e José Freitas, alugam um avião bimotor e viajam rumo a ilha de Kalahari ansiosos por revelarem a situação de Primo Alexandre e o tesouro Maori.\n");
        imprimir("No entanto, mal perceberam que, para chegar na ilha, teriam que atravessar uma tempestade com chuva, raios e ventania e torcer para o avião aguentar. \n");
        imprimir("Mas, um raio acerta o avião e destrói umas das asas do bimotor e eles caem na mata densa da floresta da ilha e em locais diferentes. \n");
    }

    static void menuInicial() {

        String apelido = "";
        boolean loopMenu = true;

        while (loopMenu == true) {

            System.out.println("--------------------------------------------------");
            imprimir("**** MENU PRINCIPAL ****");
            System.out.println("--------------------------------------------------");
            imprimir("(1) - Iniciar");
            imprimir("(2) - Instruções");
            imprimir("(3) - Sair");
            imprimir(" ");
            int opçãoMenu = numero();

            switch (opçãoMenu) {

                case 1 -> {

                    apelido = player();
                    introdução();
                    int classe = escolhaClasse();

                    if (classe == 1) {
                        loopMenu = batalha1(apelido);
                    }

                    if (classe == 2) {
                        loopMenu = batalha2(apelido);
                    }

                    if (classe == 3) {
                        loopMenu = batalha3(apelido);
                    }
                }

                case 2 ->
                    loopMenu = instruções();

                case 3 ->
                    loopMenu = false;

                default -> {

                    System.out.println("Opção inválida, tente novamente!");
                    loopMenu = true;
                }

            }
        }
    }

    public static void imprimir(String imprimir) {

        int cont = imprimir.length();

        for (int i = 0; i < cont; i++) {
            char result = imprimir.charAt(i);

            try {
                Thread.sleep(80);
                System.out.print(result);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static String texto() {
        Scanner input = new Scanner(System.in);
        String user = input.next();
        return user;
    }

    static int numero() {
        Scanner input = new Scanner(System.in);
        int user = input.nextInt();
        return user;
    }

    public static String player() {
        System.out.println("\n--------------------------------------------------");
        imprimir("Qual o seu nome aventureiro? ");
        System.out.println("--------------------------------------------------");
        String user = texto();
        return user;
    }

    public static void main(String[] args) {

        imprimir("\n=-=-=-=-=-=-=-=-=-=- KALAHARY =-=-=-=-=-=-=-=-=-=-\n");
        menuInicial();

    }
}
