package com.company;

import java.util.ArrayList;

public class State {
    protected String clientDomain;
    protected String sender;
    protected ArrayList<String> recipients;
    protected int id;
    protected Command last_command;
    enum Command { NULL, HELP, HELO, MAIL, RCPT, DATA, MSG, EDATA, QUIT}
    protected ArrayList<Command> awaited;
    protected String answer;
    protected String accept;
    protected String connect;
    protected String acknowledgment= "250 OK\r\n";
    protected String ready= "350 Start mail input; end with  <CRLF>.<CRLF>\r\n";
    protected String close;
    protected String message= "";
    protected boolean noAnswer= false;
    protected boolean helpRequest= false;

    public State(String serverName){
        //---Attributes
        this.last_command= Command.NULL;
        this.accept= "220 "+ serverName +" Simple Mail Transfer Service Ready\r\n";
        this.connect= "250 "+ serverName + "\r\n";
        this.close= "221 " + serverName + " Service closing transmission channel\r\n";
    }

    public Command requestToCommand(String request) {
        if (request.equals("HELP ")){
            this.helpRequest= true;
            return Command.HELP;
        }
        else if (request.equals("HELO ")) return Command.HELO;
        else if (request.equals("QUIT\r")) return Command.QUIT;
        else if (request.equals("MAIL ")) return Command.MAIL;
        else if (request.equals("RCPT ")) return Command.RCPT;
        else if (request.equals("DATA\r")) return Command.DATA;
        else if (request.equals("\r\n.\r\n")) return Command.EDATA;
        //TODO: are there other conditions while receiving message?
        else if (this.last_command== Command.DATA) return Command.MSG;
        //TODO: failure handling?
        else return Command.NULL;
    }
}
