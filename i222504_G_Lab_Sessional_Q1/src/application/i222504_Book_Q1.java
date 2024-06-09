package application;

public class i222504_Book_Q1 {
		private int id;
	    private String title;
	    private String author;
	    private int ISBN;
	    private boolean availability;


	    public i222504_Book_Q1(int id,String title, String author, int iSBN, boolean availability) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			ISBN = iSBN;
			this.availability = availability;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getAuthor() {
			return author;
		}


		public void setAuthor(String author) {
			this.author = author;
		}


		public int getISBN() {
			return ISBN;
		}


		public void setISBN(int iSBN) {
			ISBN = iSBN;
		}


		public boolean isAvailability() {
			return availability;
		}


		public void setAvailability(boolean availability) {
			this.availability = availability;
		}
	    
}
