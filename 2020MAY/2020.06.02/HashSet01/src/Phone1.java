
public class Phone1 {
	private String number;
	private Integer price;
	
	public Phone1(String number, Integer price) {
		this.number = number;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone1 [number=" + number + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number==null)?0:number.hashCode());
		result = prime * result + ((price==null)?0:price.hashCode());
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
		Phone1 other = (Phone1) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		}
		else if (!number.equals(other.number))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		}
		else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	
	
}
