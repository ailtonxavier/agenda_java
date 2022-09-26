package visao;
import dominio.Pessoa;
import java.util.Scanner;
import java.util.ArrayList;
//Crie uma classe Principal que seja capaz de armazenar várias pessoas (na lista Agenda) e seja
//capaz ainda de realizar as seguintes operações: cadastrar pessoa, remover pessoa, buscar pessoa,
//informar um dado específico de uma pessoa (nome, telefone ou e-mail) e escrever toda a agenda.
public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Pessoa> Agenda = new ArrayList<Pessoa>();
        Pessoa p;

        int op, i;
        boolean achou;
        String nomeAux;
        do {
            System.out.println("################## MENU ##################");
            System.out.println("1 - INCLUIR CONTATO");
            System.out.println("2 - EXLCUIR CONTATO");
            System.out.println("3 - BUSCAR CONTATO");
            System.out.println("4 - INFORMAR UM DADO ESPECIFICO DO CONTATO");
            System.out.println("5 - ESCREVER TODA AGENDA");
            System.out.println("6 - SAIR");
            op = teclado.nextInt();



            switch(op){
                case 1:
                    achou = false;
                    System.out.println("1 - INCLUIR CONTATO");
                    p = new Pessoa();
                    System.out.println("DIGITE O NOME DO CONTATO: ");
                    teclado.nextLine(); //  absorver o enter
                    nomeAux = teclado.nextLine();
                    for(i = 0; i < Agenda.size(); i++){
                        if(nomeAux.equals(Agenda.get(i).getNome())){
                            achou = true;
                            System.out.println("CONTATO JÁ EXISTE NA AGENDA!");
                            break;
                        }
                    }
                    if(!achou){
                        p.setNome(nomeAux);
                        System.out.println("DIGITE O TELEFONE: ");
                        p.setTelefone(teclado.nextLine());
                        System.out.println("DIGITE O EMAIL: ");
                        p.setEmail(teclado.nextLine());
                        Agenda.add(p);
                    }
                    break;
                case 2:
                    achou = false;
                    System.out.println("2 - EXLCUIR CONTATO");
                    System.out.println("DIGITE O NOME DO CONTATO: ");
                    teclado.nextLine(); //  absorver o enter
                    nomeAux = teclado.nextLine();
                    for(i = 0; i < Agenda.size(); i++){
                        if(nomeAux.equals(Agenda.get(i).getNome())){
                            achou = true;
                            Agenda.remove(i);
                            System.out.println("CONTATO EXCLUIDO!");
                            break;
                        }
                    }
                    if(!achou){
                        System.out.println("CONTATO INEXISTENTE!");
                    }
                    break;
                case 3:
                    achou = false;
                    System.out.println("3 - BUSCAR CONTATO");
                    System.out.println("DIGITE O NOME DO CONTATO: ");
                    teclado.nextLine(); //  absorver o enter
                    nomeAux = teclado.nextLine();
                    for(i = 0; i < Agenda.size(); i++){
                        if(nomeAux.equals(Agenda.get(i).getNome())){
                            achou = true;
                            System.out.println(Agenda.get(i).retornaDados());
                            break;
                        }
                    }
                    if(!achou){
                        System.out.println("CONTATO INEXISTENTE!");
                    }

                    break;
                case 4:
                    achou = false;
                    System.out.println("4 - INFORMAR UM DADO ESPECIFICO DO CONTATO");

                    System.out.println("DIGITE O NOME DO CONTATO: ");
                    teclado.nextLine(); //  absorver o enter
                    nomeAux = teclado.nextLine();
                    for(i = 0; i < Agenda.size(); i++){
                        if(nomeAux.equals(Agenda.get(i).getNome())){
                            achou = true;
                            System.out.println("QUAL DADO VOCÊ DESEJA?\n(1) - TELEFONE (2) - EMAIL");
                            if (teclado.nextInt() == 1) {
                                System.out.println(Agenda.get(i).getTelefone());
                            } else {
                                System.out.println(Agenda.get(i).getEmail());
                            }
                            break;
                        }
                    }
                    if(!achou){
                        System.out.println("CONTATO INEXISTENTE!");
                    }
                    break;
                case 5:
                    System.out.println("5 - ESCREVER TODA AGENDA");
                    if(Agenda.size() > 0){
                        for(i = 0; i < Agenda.size(); i++){
                            System.out.println(Agenda.get(i).retornaDados());
                        }
                    } else {
                        System.out.println("NÃO HÁ CONTATOS NA AGENDA!");
                    }
                    break;
                case 6:
                    System.out.println("ENCERRANDO PROGRAMA!");
                    break;
            }
        }while(op != 6);
    }
}
