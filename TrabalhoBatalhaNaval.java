package exercicios.trabalhobatalhanaval;

import java.util.Random;
import java.util.Scanner;

public class TrabalhoBatalhaNaval {

    public static void main(String[] args) {
        Random aleatorio = new Random();
        Scanner ler = new Scanner(System.in);

        int estiloJogo;

        System.out.print(" |   Sozinho   |  Cntr. Bot  |  Cntr. Pessoa  \n |   -> 1 <-   |   -> 2 <-   |    -> 3 <-  \n\n");
        System.out.print("        Escolha o seu estilo de jogo!\n\n");
        System.out.print(" ---> ");
        estiloJogo = ler.nextInt();

//Início do estilo de jogo sozinho//        
        if (estiloJogo == 1) {
            int[][] matriz1 = new int[10][10];
            String[][] matriz2 = new String[10][10];
            int l, c, contagemBarco = 0, nBarco = 0;
            int cTeste, lTeste;
            char lerChar;
            int charNumero;
            int nJogadas = 0;
            int nJogadasErradas = 0;
//Início da criação aleatória de quais espaços tem barco e quais tem água//

            System.out.print("\n\nGabarito da localização dos barcos\n\n");

            for (l = 0; l < 10; l++) {
                for (c = 0; c < 10; c++) {
                    matriz1[l][c] = aleatorio.nextInt(1, 100);
                    if (matriz1[l][c] % 13 == 0 && nBarco < 5) {
                        matriz1[l][c] = 'B';
                        contagemBarco++;
                        nBarco++;
                    } else {
                        matriz1[l][c] = '~';
                    }
                    System.out.printf("%c ", matriz1[l][c]);
                }
                System.out.println("");
            }

//Fim da criação aleatória de quais espaços tem barco e quais tem água//        
            System.out.println("\n\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n\nGabarito!\n\n\n");

//Início do código de mostrar na tela a tabela para selecionar os lugares de teste//
// Início vetor para mostrar a letra representante da coluna//
            char letra = 'a';

            for (c = 0; c < 10; c++) {
                System.out.printf(" %c  ", letra);
                letra++;
            }

// Fim vetor para mostrar a letra representante da coluna//
            System.out.println("");

            for (l = 0; l < 10; l++) {
                System.out.print(" _  ");
            }
            System.out.println("");

            for (l = 0; l < 10; l++) {
                for (c = 0; c < 10; c++) {
                    matriz2[l][c] = "|_|";
                    System.out.printf("%s ", matriz2[l][c]);
                }
                System.out.print(" " + l);
                System.out.println("");
            }

//Fim do código de mostrar na tela a tabela para selecionar os lugares de teste//        
            System.out.println("");

//Início da verificação de existencia de algum barco no posição escolhida//
            do {
                System.out.printf("\n\nNa tela, ainda há um total de %d barcos!!\n", contagemBarco);

                System.out.print("\nSeleciona a coluna que você quer testar (A a J): ");
                lerChar = ler.next().charAt(0);
                charNumero = Character.getNumericValue(lerChar);
                charNumero = charNumero - 10;
                System.out.print("Agora selecione qual linha você quer testar (0 a 9): ");
                lTeste = ler.nextInt();

                if (matriz1[lTeste][charNumero] == 'B') {
                    System.out.print("\nParabéns, você acertou um barco!");
                    matriz2[lTeste][charNumero] = "|X|";
                    contagemBarco--;
                    nJogadas++;
                } else {
                    System.out.print("\nVocê não acertou nenhum barco!");
                    matriz2[lTeste][charNumero] = "|~|";
                    nJogadas++;
                    nJogadasErradas++;
                }

//Fim da verificação de existencia de algum barco no posição escolhida//
                System.out.println("\n");

//Início da apresentação na tela o resultado do teste//
                letra = 'a';

                for (c = 0; c < 10; c++) {
                    System.out.printf(" %c  ", letra);
                    letra++;
                }

                System.out.println("");

                for (l = 0; l < 10; l++) {
                    System.out.print(" _  ");
                }
                System.out.println("");

                for (l = 0; l < 10; l++) {
                    for (c = 0; c < 10; c++) {
                        if (lTeste == l && charNumero == c) {
                            System.out.print(matriz2[lTeste][charNumero] + " ");
                        } else {
                            System.out.print(matriz2[l][c] + " ");
                        }
                    }
                    System.out.print("  " + l);
                    System.out.println("");
                }
//Fim da apresentação na tela o resultado do teste//        

            } while (contagemBarco != 0);

            System.out.print("\n\nParabéns, você conseguiu destruir todos os barcos!!");
            System.out.printf("\nVocê fez um total de %d jogadas, e errou um total de %d vezes", nJogadas, nJogadasErradas);

//Fim do estilo de jogo sozinho//
//Início do estilo de jogo contra Bot//
        } else if (estiloJogo == 2) {
            int[][] matrizBot1 = new int[10][10];
            String[][] matrizBot2 = new String[10][10];
            String[][] matrizPlayer2 = new String[10][10];

            int l, c;
            int quantidadeBarcoBot = 5, quantidadeBarcoPlayer = 5, contagemBarcoBot = 0;
            char lerChar;
            int charNumero;
            int quantidadeRodada = 0;

//Início da criação da tabela do Bot//
            for (l = 0; l < 10; l++) {
                for (c = 0; c < 10; c++) {
                    matrizBot1[c][l] = aleatorio.nextInt(1, 50);
                    if (matrizBot1[c][l] % 11 == 0 && contagemBarcoBot < 5) {
                        matrizBot1[c][l] = 'B';
                        contagemBarcoBot++;
                    } else {
                        matrizBot1[c][l] = '~';
                    }
                    System.out.printf("%c ", matrizBot1[c][l]);
                }
                System.out.println("");
            }

            System.out.println("\n\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n  ^\n  |\n  |\n\nGabarito do bot!\n\n\n");

            
//Fim da criação da tabela do Bot//   
            char letra = 'a';

            for (c = 0; c < 10; c++) {
                System.out.printf(" %c  ", letra);
                letra++;
            }

            System.out.println("");

            for (l = 0; l < 10; l++) {
                System.out.print(" _  ");
            }
            System.out.println("");

            for (l = 0; l < 10; l++) {
                for (c = 0; c < 10; c++) {
                    matrizPlayer2[l][c] = "|_|";
                    System.out.printf("%s ", matrizPlayer2[l][c]);
                }
                System.out.print(" " + l);
                System.out.println("");
            }

            int vez = 0;
            int nBarcos = 5;
            int lerL = 0;

            for (l = 0; l < 10; l++) {
                for (c = 0; c < 10; c++) {
                    matrizBot2[c][l] = "|_|";
                }
            }

            do {
                System.out.printf("\n\nSelecione %d posições para colocar um barco!\n\n", nBarcos);
                System.out.print("Digite a coluna que você pretende colocar o barco ('A' até 'J'): ");
                lerChar = ler.next().charAt(0);
                charNumero = Character.getNumericValue(lerChar);
                charNumero = charNumero - 10;
                System.out.print("Digite a linha que você pretende colocar o barco (0 até 9): ");
                c = ler.nextInt();
                System.out.println("");

                matrizPlayer2[charNumero][c] = "|B|";
                nBarcos--;
                vez++;
            } while (vez < 5);

            System.out.print("\n\nAs posições que você selecionou foram: \n\n");

            letra = 'a';

            for (c = 0; c < 10; c++) {
                System.out.printf(" %c  ", letra);
                letra++;
            }

            System.out.println("");

            for (l = 0; l < 10; l++) {
                System.out.print(" _  ");
            }
            System.out.println("");

            for (l = 0; l < 10; l++) {
                for (c = 0; c < 10; c++) {
                    System.out.printf("%s ", matrizPlayer2[c][l]);
                }
                System.out.print(" " + l);
                System.out.println("");
            }

            System.out.print("\n\nA partira irá começar, se prepare!!\n\n");
            l = 0;
            c = 0;

            do {
                System.out.print("\n\nO bot irá jogar!\n\n");
                l = aleatorio.nextInt(0, 9);
                c = aleatorio.nextInt(0, 9);

//Inicio da verificação se o bot acertou o barco//
                if (matrizPlayer2[c][l] == "|B|") {
                    System.out.printf("\nO Bot acertou um barco!\n\n");
                    matrizPlayer2[c][l] = "|X|";
                    quantidadeBarcoPlayer--;
                } else {
                    System.out.printf("\nO Bot não acertou nenhum barco!\n\n");
                    matrizPlayer2[c][l] = "|~|";
                }

                letra = 'a';

                for (c = 0; c < 10; c++) {
                    System.out.printf(" %c  ", letra);
                    letra++;
                }

                System.out.println("");

                for (l = 0; l < 10; l++) {
                    System.out.print(" _  ");
                }

                System.out.println("");

                for (l = 0; l < 10; l++) {
                    for (c = 0; c < 10; c++) {
                        System.out.printf("%s ", matrizPlayer2[c][l]);
                    }
                    System.out.print(" " + l);
                    System.out.println("");
                }

//Fim da verificação se o bot acertou o barco//
                System.out.println(" \n\n\n");

                System.out.print("\n\nAgora é a sua vez de tentar acertar algum barco do inimigo!!\n");

                System.out.print("Em qual coluna você gostaria de testar? --> ");
                lerChar = ler.next().charAt(0);
                charNumero = Character.getNumericValue(lerChar);
                charNumero = charNumero - 10;
                System.out.print("Em qual linha você gostaria de testar? --> ");
                lerL = ler.nextInt();
                System.out.println("");

//Início verificação se o player acertou algum barco//

                if (matrizBot1[charNumero][lerL] == 'B') {
                    System.out.printf("\nVocê acertou um barco!\n\n");
                    matrizBot2[charNumero][lerL] = "|X|";
                    quantidadeBarcoBot--;
                } else {
                    System.out.printf("\nVocê não acertou nenhum barco!\n\n");
                    matrizBot2[charNumero][lerL] = "|~|";
                }

                letra = 'a';

                for (c = 0; c < 10; c++) {
                    System.out.printf(" %c  ", letra);
                    letra++;
                }

                System.out.println("");

                for (l = 0; l < 10; l++) {
                    System.out.print(" _  ");
                }
                System.out.println("");

                for (l = 0; l < 10; l++) {
                    for (c = 0; c < 10; c++) {
                        System.out.print(matrizBot2[c][l] + " ");
                    }
                    System.out.print("  " + l);
                    System.out.println("");
                }

                quantidadeRodada++;

//Fim da verificação se o player acertou algum barco//

            } while (quantidadeBarcoBot > 0 && quantidadeBarcoPlayer > 0);

            if (quantidadeBarcoBot == 0) {
                System.out.print("\n\n\nParabéns, você conseguiu vencer o bot, destruindo todos os seus navios!!\nA partida durou " + quantidadeRodada + "rodadas.");
            } else {
                System.out.print("\n\n\nInfelizmente você não conseguiu vencer. Tente novamente uma outra hora!\nA partida durou " + quantidadeRodada + " rodadas.");
            }
        } 
//Fim do estilo de jogo contra Bot// 
//Início do estilo de jogo contra Player//
        
        else if (estiloJogo == 3) {
            int l, c;
        String[][] matrizPlayer2 = new String[10][10];
        String[][] matrizPlayer1 = new String[10][10];
        char lerChar;
        int charNumero, erro = 0;

        System.out.println("\nVocê irá jogar o modo player Vs player!!");

        System.out.println("\nCerto, então vamos montar a sua tabela, player 1!");
        System.out.println("Selecione os lugares na tabela que você quer que tenham os barcos:\n\n");

        int numeroBarcos = 10;

// Início mostrando tabela vazia do player 1
        char letra = 'a';

        for (c = 0; c < 10; c++) {
            System.out.printf(" %c  ", letra);
            letra++;
        }
        System.out.println("");

        for (l = 0; l < 10; l++) {
            System.out.print(" _  ");
        }
        System.out.println("");

        for (l = 0; l < 10; l++) {
            for (c = 0; c < 10; c++) {
                matrizPlayer2[l][c] = "|_|";
                System.out.printf("%s ", matrizPlayer2[l][c]);
            }
            System.out.print(" " + l);
            System.out.println("");
        }
        
//Fim mostrando tabela player 1        
//Inicio selecionando posição dos barcos do player 1
        do {
            System.out.print("\n\nVocê pode colocar 1 barco!\n\n");
            System.out.print("Digite a coluna que você pretende colocar o barco de quatro espaços ('A' até 'J'): ");
            lerChar = ler.next().charAt(0);
            charNumero = Character.getNumericValue(lerChar);
            charNumero = charNumero - 10;

            do {
                if (charNumero + 3 > 10) {
                    System.out.print("O barco é maior que a tabela, selecione outro lugar");
                    erro++;
                } else {
                    System.out.print("Digite a linha que você pretende colocar o barco (0 até 9): ");
                    c = ler.nextInt();
                    System.out.println("");

                    if (c >= 0 && c <= 9) {
                        matrizPlayer2[charNumero][c] = "|A|";
                        matrizPlayer2[charNumero + 1][c] = "|A|";
                        matrizPlayer2[charNumero + 2][c] = "|A|";
                        matrizPlayer2[charNumero + 3][c] = "|A|";

                        letra = 'a';

                        for (c = 0; c < 10; c++) {
                            System.out.printf(" %c  ", letra);
                            letra++;
                        }

                        System.out.println("");

                        for (l = 0; l < 10; l++) {
                            System.out.print(" _  ");
                        }
                        System.out.println("");

                        for (l = 0; l < 10; l++) {
                            for (c = 0; c < 10; c++) {
                                System.out.printf("%s ", matrizPlayer2[c][l]);
                            }
                            System.out.print(" " + l);
                            System.out.println("");
                        }
                    }
                    numeroBarcos--;
                }
            } while (charNumero > 10 && erro == 0);
        } while (numeroBarcos > 9);

        erro = 0;

        do {
            System.out.print("\nVocê pode colocar 2 barcos!\n\n");
            System.out.print("Digite a coluna que você pretende colocar o barco de três espaços ('A' até 'J'): ");
            lerChar = ler.next().charAt(0);
            charNumero = Character.getNumericValue(lerChar);
            charNumero = charNumero - 10;

            do {
                if (charNumero + 2 > 10) {
                    System.out.print("O barco é maior que a tabela, selecione outro lugar");
                } else {
                    System.out.print("Digite a linha que você pretende colocar o barco (0 até 9): ");
                    c = ler.nextInt();
                    System.out.println("");

                    if ("|A|".equals(matrizPlayer2[charNumero][c]) || "|B|".equals(matrizPlayer2[charNumero][c])) {
                        System.out.print("\nVocê selecionou um lugar onde já tem um barco! Escolha outro lugar\n");
                        erro++;
                    } else {
                        if (c >= 0 && c <= 9) {
                            matrizPlayer2[charNumero][c] = "|B|";
                            matrizPlayer2[charNumero + 1][c] = "|B|";
                            matrizPlayer2[charNumero + 2][c] = "|B|";

                            letra = 'a';

                            for (c = 0; c < 10; c++) {
                                System.out.printf(" %c  ", letra);
                                letra++;
                            }

                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                System.out.print(" _  ");
                            }
                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                for (c = 0; c < 10; c++) {
                                    System.out.printf("%s ", matrizPlayer2[c][l]);
                                }
                                System.out.print(" " + l);
                                System.out.println("");
                            }
                        }
                        numeroBarcos--;
                    }
                }

            } while (charNumero > 10 && erro == 0);
        } while (numeroBarcos > 7);

        erro = 0;

        do {
            System.out.print("\nVocê pode colocar 3 barcos!\n\n");
            System.out.print("Digite a coluna que você pretende colocar o barco de dois espaços ('A' até 'J'): ");
            lerChar = ler.next().charAt(0);
            charNumero = Character.getNumericValue(lerChar);
            charNumero = charNumero - 10;

            do {
                if (charNumero + 1 > 10) {
                    System.out.print("O barco é maior que a tabela, selecione outro lugar");
                } else {
                    System.out.print("Digite a linha que você pretende colocar o barco (0 até 9): ");
                    c = ler.nextInt();
                    System.out.println("");

                    if (matrizPlayer2[charNumero][c] == "|A|" || matrizPlayer2[charNumero][c] == "|B|" || matrizPlayer2[charNumero][c] == "|C|" || matrizPlayer2[charNumero][c] == "|D|") {
                        System.out.print("Você selecionou um lugar onde já tem um barco! Escolha outro lugar");
                        erro++;
                    } else {
                        if (c >= 0 && c <= 9) {
                            matrizPlayer2[charNumero][c] = "|C|";
                            matrizPlayer2[charNumero + 1][c] = "|C|";

                            letra = 'a';

                            for (c = 0; c < 10; c++) {
                                System.out.printf(" %c  ", letra);
                                letra++;
                            }

                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                System.out.print(" _  ");
                            }
                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                for (c = 0; c < 10; c++) {
                                    System.out.printf("%s ", matrizPlayer2[c][l]);
                                }
                                System.out.print(" " + l);
                                System.out.println("");
                            }
                        }
                        numeroBarcos--;
                    }
                }

            } while (charNumero > 10 && erro == 0);
        } while (numeroBarcos > 4);

        erro = 0;

        do {
            System.out.print("\nVocê pode colocar 4 barcos!\n\n");
            System.out.print("Digite a coluna que você pretende colocar o barco de um espaços ('A' até 'J'): ");
            lerChar = ler.next().charAt(0);
            charNumero = Character.getNumericValue(lerChar);
            charNumero = charNumero - 10;

            do {
                if (charNumero + 1 > 10) {
                    System.out.print("O barco é maior que a tabela, selecione outro lugar");
                } else {
                    System.out.print("Digite a linha que você pretende colocar o barco (0 até 9): ");
                    c = ler.nextInt();
                    System.out.println("");

                    if (matrizPlayer2[charNumero][c] == "|A|" || matrizPlayer2[charNumero][c] == "|B|" || matrizPlayer2[charNumero][c] == "|C|" || matrizPlayer2[charNumero][c] == "|D|") {
                        System.out.print("Você selecionou um lugar onde já tem um barco! Escolha outro lugar");
                        erro++;
                    } else {
                        if (c >= 0 && c <= 9) {
                            matrizPlayer2[charNumero][c] = "|D|";

                            letra = 'a';

                            for (c = 0; c < 10; c++) {
                                System.out.printf(" %c  ", letra);
                                letra++;
                            }

                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                System.out.print(" _  ");
                            }
                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                for (c = 0; c < 10; c++) {
                                    System.out.printf("%s ", matrizPlayer2[c][l]);
                                }
                                System.out.print(" " + l);
                                System.out.println("");
                            }
                        }
                        numeroBarcos--;
                    }

                }
            } while (charNumero > 10 && erro == 0);
        } while (numeroBarcos > 0);

        erro = 0;

//Fim selecionando posição dos barcos do player 1    

    System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
    System.out.print("\nCerto, então vamos começar a montar a tabela do player 2");
    System.out.print("\nEstá é sua tabela vazia, vamos montar!\n\n");
 
// Criando tabela player 2   
//Inicio apresentação tabela vazia
        letra = 'a';

        for (c = 0; c < 10; c++) {
            System.out.printf(" %c  ", letra);
            letra++;
        }
        System.out.println("");

        for (l = 0; l < 10; l++) {
            System.out.print(" _  ");
        }
        System.out.println("");

        for (l = 0; l < 10; l++) {
            for (c = 0; c < 10; c++) {
                matrizPlayer1[l][c] = "|_|";
                System.out.printf("%s ", matrizPlayer1[l][c]);
            }
            System.out.print(" " + l);
            System.out.println("");
        }

// Fim apresentação tabela vazia
// Inicio posivionamento barco do player 2
        numeroBarcos = 10;

        do {
            System.out.print("\n\nVocê pode colocar 1 barco!\n\n");
            System.out.print("Digite a coluna que você pretende colocar o barco de quatro espaços ('A' até 'J'): ");
            lerChar = ler.next().charAt(0);
            charNumero = Character.getNumericValue(lerChar);
            charNumero = charNumero - 10;

            do {
                if (charNumero + 3 > 10) {
                    System.out.print("O barco é maior que a tabela, selecione outro lugar");
                    erro++;
                } else {
                    System.out.print("Digite a linha que você pretende colocar o barco (0 até 9): ");
                    c = ler.nextInt();
                    System.out.println("");

                    if (c >= 0 && c <= 9) {
                        matrizPlayer1[charNumero][c] = "|A|";
                        matrizPlayer1[charNumero + 1][c] = "|A|";
                        matrizPlayer1[charNumero + 2][c] = "|A|";
                        matrizPlayer1[charNumero + 3][c] = "|A|";

                        letra = 'a';

                        for (c = 0; c < 10; c++) {
                            System.out.printf(" %c  ", letra);
                            letra++;
                        }

                        System.out.println("");

                        for (l = 0; l < 10; l++) {
                            System.out.print(" _  ");
                        }
                        System.out.println("");

                        for (l = 0; l < 10; l++) {
                            for (c = 0; c < 10; c++) {
                                System.out.printf("%s ", matrizPlayer1[c][l]);
                            }
                            System.out.print(" " + l);
                            System.out.println("");
                        }
                    }
                    numeroBarcos--;
                }
            } while (charNumero > 10 && erro == 0);
        } while (numeroBarcos > 9);

        erro = 0;

        do {
            System.out.print("\nVocê pode colocar 2 barcos!\n\n");
            System.out.print("Digite a coluna que você pretende colocar o barco de três espaços ('A' até 'J'): ");
            lerChar = ler.next().charAt(0);
            charNumero = Character.getNumericValue(lerChar);
            charNumero = charNumero - 10;

            do {
                if (charNumero + 2 > 10) {
                    System.out.print("O barco é maior que a tabela, selecione outro lugar");
                } else {
                    System.out.print("Digite a linha que você pretende colocar o barco (0 até 9): ");
                    c = ler.nextInt();
                    System.out.println("");

                    if ("|A|".equals(matrizPlayer1[charNumero][c]) || "|B|".equals(matrizPlayer1[charNumero][c])) {
                        System.out.print("\nVocê selecionou um lugar onde já tem um barco! Escolha outro lugar\n");
                        erro++;
                    } else {
                        if (c >= 0 && c <= 9) {
                            matrizPlayer1[charNumero][c] = "|B|";
                            matrizPlayer1[charNumero + 1][c] = "|B|";
                            matrizPlayer1[charNumero + 2][c] = "|B|";

                            letra = 'a';

                            for (c = 0; c < 10; c++) {
                                System.out.printf(" %c  ", letra);
                                letra++;
                            }

                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                System.out.print(" _  ");
                            }
                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                for (c = 0; c < 10; c++) {
                                    System.out.printf("%s ", matrizPlayer1[c][l]);
                                }
                                System.out.print(" " + l);
                                System.out.println("");
                            }
                        }
                        numeroBarcos--;
                    }
                }

            } while (charNumero > 10 && erro == 0);
        } while (numeroBarcos > 7);

        erro = 0;

        do {
            System.out.print("\nVocê pode colocar 3 barcos!\n\n");
            System.out.print("Digite a coluna que você pretende colocar o barco de dois espaços ('A' até 'J'): ");
            lerChar = ler.next().charAt(0);
            charNumero = Character.getNumericValue(lerChar);
            charNumero = charNumero - 10;

            do {
                if (charNumero + 1 > 10) {
                    System.out.print("O barco é maior que a tabela, selecione outro lugar");
                } else {
                    System.out.print("Digite a linha que você pretende colocar o barco (0 até 9): ");
                    c = ler.nextInt();
                    System.out.println("");

                    if (matrizPlayer1[charNumero][c] == "|A|" || matrizPlayer1[charNumero][c] == "|B|" || matrizPlayer1[charNumero][c] == "|C|" || matrizPlayer1[charNumero][c] == "|D|") {
                        System.out.print("Você selecionou um lugar onde já tem um barco! Escolha outro lugar");
                        erro++;
                    } else {
                        if (c >= 0 && c <= 9) {
                            matrizPlayer1[charNumero][c] = "|C|";
                            matrizPlayer1[charNumero + 1][c] = "|C|";

                            letra = 'a';

                            for (c = 0; c < 10; c++) {
                                System.out.printf(" %c  ", letra);
                                letra++;
                            }

                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                System.out.print(" _  ");
                            }
                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                for (c = 0; c < 10; c++) {
                                    System.out.printf("%s ", matrizPlayer1[c][l]);
                                }
                                System.out.print(" " + l);
                                System.out.println("");
                            }
                        }
                        numeroBarcos--;
                    }
                }

            } while (charNumero > 10 && erro == 0);
        } while (numeroBarcos > 4);

        erro = 0;

        do {
            System.out.print("\nVocê pode colocar 4 barcos!\n\n");
            System.out.print("Digite a coluna que você pretende colocar o barco de um espaços ('A' até 'J'): ");
            lerChar = ler.next().charAt(0);
            charNumero = Character.getNumericValue(lerChar);
            charNumero = charNumero - 10;

            do {
                if (charNumero + 1 > 10) {
                    System.out.print("O barco é maior que a tabela, selecione outro lugar");
                } else {
                    System.out.print("Digite a linha que você pretende colocar o barco (0 até 9): ");
                    c = ler.nextInt();
                    System.out.println("");

                    if (matrizPlayer1[charNumero][c] == "|A|" || matrizPlayer1[charNumero][c] == "|B|" || matrizPlayer1[charNumero][c] == "|C|" || matrizPlayer1[charNumero][c] == "|D|") {
                        System.out.print("Você selecionou um lugar onde já tem um barco! Escolha outro lugar");
                        erro++;
                    } else {
                        if (c >= 0 && c <= 9) {
                            matrizPlayer1[charNumero][c] = "|D|";

                            letra = 'a';

                            for (c = 0; c < 10; c++) {
                                System.out.printf(" %c  ", letra);
                                letra++;
                            }

                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                System.out.print(" _  ");
                            }
                            System.out.println("");

                            for (l = 0; l < 10; l++) {
                                for (c = 0; c < 10; c++) {
                                    System.out.printf("%s ", matrizPlayer1[c][l]);
                                }
                                System.out.print(" " + l);
                                System.out.println("");
                            }
                        }
                        numeroBarcos--;
                    }

                }
            } while (charNumero > 10 && erro == 0);
        } while (numeroBarcos > 0);

        erro = 0;

        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.print("\n\nCerto, agora que estamos prontos, Lets PLay!");
        System.out.println("\nÉ o seguinte, o player 1 sempre começa jogando, Partiu!\n");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        System.out.println("\n\n\nPlayer 1, escolha o lugar que você quer testar para ver se tem barco!");

        } else {
            System.out.print("\nEscolha errada! (Escolha uma das opções apresentadas na tela*)\n");
        }
//Fim do estilo de jogo contra player//
    }
}
