package com.manoelcampos.message;

import com.manoelcampos.people.Customer;

import java.util.List;

/**
 * Envia mensagens em massa para uma lista de clientes,
 * utilizando algum {@link MessageService}.
 *
 * @author Manoel Campos da Silva Filho
 */
public abstract class Newsletter {
    private final List<Customer> customers;
    private MessageService messageService;

    /**
     * Instancia uma newsletter para envio de mensagens para uma determinada lista de clientes
     * @param customers lista de clientes para enviar mensagens
     */
    public Newsletter(final List<Customer> customers){
        this.customers = customers;
        this.messageService = createMessageService();
    }

    /**
     * Cria uma instância de {@link MessageService} que será utilizada
     * para enviar as mensagens.
     * */
    protected abstract MessageService createMessageService();

    /**
     * Envia uma mensagem personalizada para uma lista de clientes.
     * Não é obrigatória a inclusão de marcadores no template.
     * Um exemplo de template seria:
     *      Olá #name, seu telefone foi atualizado para #phone.
     * @param msgTemplate Um template de mensagem com marcações (placeholders)
     *        que serão substituídos por atributos do cliente de destino.
     */
    public void send(final String msgTemplate) {
        for (final Customer customer : customers) {
            messageService.send(customer.getPhone(), formatMsg(customer, msgTemplate));
        }
    }

    /**
     * Substitui marcações (placeholders) na mensagem por valores
     * de atributos de um cliente.
     *
     * @param customer cliente de destino
     * @param msgTemplate Um template de mensagem com marcações (placeholders)
     *        que serão substituídos por atributos do cliente de destino.
     * @return a mensagem com as marcações substituídas pelos atributos do cliente.
     */
    private String formatMsg(final Customer customer, final String msgTemplate) {
        return msgTemplate
            .replaceAll("#name", customer.getName())
            .replaceAll("#email", customer.getEmail())
            .replaceAll("#phone", customer.getPhone());
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
