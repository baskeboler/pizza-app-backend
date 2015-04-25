package com.pizza.models;



public class EstadoPedido {
	public enum Estado {
		ESPERANDO(1) {
			public Estado next() {
				return PREPARANDO;
			}
		},
		PREPARANDO(2) {
			public Estado next() {
				return PREPARADO;
			}
		},
		PREPARADO(3) {
			public Estado next() {
				return ENTREGADO;
			}
		},
		ENTREGADO(4) {
			public Estado next() {
				return ENTREGADO;
			}
		};
		private int id;

		private Estado(int v) {
			this.id = v;
		}

		private int progress() {
			return 25 * id;
		}

		public abstract Estado next();
	}

	private Estado estado;

	public EstadoPedido() {
		this.estado = Estado.ESPERANDO;
	}
	
	public EstadoPedido(Estado estado) {
		this.estado = estado;
	}
	
	public String toString() {
		return estado.toString();
	}
	
	public Estado getId() {
		return estado;
	}
	
	public void setEstado(Estado e) {
		estado = e;
	}
	
	public int getProgreso() {
		return estado.progress();
	}
	
	public boolean isCompleto() {
		return estado == Estado.ENTREGADO;
	}

	
}
