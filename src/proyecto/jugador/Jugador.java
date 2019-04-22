package proyecto.jugador;

import proyecto.enums.Colores;

public class Jugador {

	private final String nombre;
	private final String username;
	private final Colores color;
	private final String email;
	private final String sexo;

	private Jugador(String pnombre, String pusername, Colores pcolor, String pemail, String psexo) {
		nombre = pnombre;
		username = pusername;
		color = pcolor;
		email = pemail;
		sexo = psexo;
	}

	public static class JugadorBuilder {
		private String nnombre;
		private String nusername;
		private Colores ncolor;
		private String nemail;
		private String nsexo;

		public JugadorBuilder() {

		}

		public JugadorBuilder withNombre(String newNombre) {
			this.nnombre = newNombre;
			return this;
		}

		public JugadorBuilder withUsername(String newUsername) {
			this.nusername = newUsername;
			return this;
		}

		public JugadorBuilder withColor(Colores newColor) {
			this.ncolor = newColor;
			return this;
		}

		public JugadorBuilder withEmail(String newEmail) {
			this.nemail = newEmail;
			return this;
		}

		public JugadorBuilder withSexo(String newSexo) {
			this.nsexo = newSexo;
			return this;
		}

		public Jugador build() {
			return new Jugador(nnombre, nusername, ncolor, nemail, nsexo);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jugador: " + username + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public String getUsername() {
		return username;
	}

	public Colores getColor() {
		return color;
	}

	public String getEmail() {
		return email;
	}

	public String getSexo() {
		return sexo;
	}

}
