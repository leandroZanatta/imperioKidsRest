package br.com.sysdesc.imperio.kids.util;

import java.io.Serializable;

public class SysDescException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final SysDescModel sysDescModel;

	public SysDescException(String mensagem) {

		super(mensagem);

		this.sysDescModel = new SysDescModel(mensagem);
	}

	public String getMensagem() {
		return this.sysDescModel.getMensagem();
	}

}

class SysDescModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensagem;

	public SysDescModel(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}