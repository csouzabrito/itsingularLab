package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum TipoBanco {

	BCO_DO_BRASIL("001-Banco do Brasil"),
	BCO_BRADESCO("237-Banco Bradesco"),
	BCO_CEF("104-Caixa Econômica Federal"),
	BCO_ITAU("341-Banco Itaú"),
	BCO_SAFRA("422-Banco Safra"),
	BCO_SANTANDER("033-Banco Santander"),
	BCO_ORIGINAL("212-Banco Original"),
	BCO_INTER("077-Banco Inter"),
	BCO_NULBANK("266-Nulbank"),
	BCO_NEON("735-Banco Neon"),
	BCO_C6("336-Banco C6"),
	BCO_ABC("246-Banco ABC Brasil"),
	BCO_ALFA("025-Banco Alfa"),
	BCO_ALVORADA("641-Banco Alvorada"),
	BCO_BANERJ("029-Banco Banerj"),
	BCO_BMG("318-Banco BMG"),
	BCO_BNP("752-Banco BNP Paribas Brasil"),
	BCO_CRUZEIRO_SUL("229-Banco Cruzeiro do Sul"),
	BCO_AMAZONIA("003-Banco da Amazônia"),
	BCO_DAYCOVAL("707-Banco Daycoval"),
	BCO_PERNAMBUCO("024-Banco de Pernambuco"),
	BCO_MODAL("746-Banco Modal"),
	BCO_PAN("623-Banco Panamericano"),
	BCO_SOFISA("637-Banco Sofisa"),
	BCO_VOTORANTIM("655-Banco Votorantim");
	
	private String banco;
}
