/*
 *You can just get the top item in the stack,what is first inserted is in the bottom of stack!
 *Compile command ： javac LinkStackApp.java
 *Run command : java LinkStackApp
 *
 *
*/
class Link
{
	public long dData;
	public Link next;
	public Link(long dData)
	{
		this.dData = dData;
	}
	public void displayLink()
	{
		System.out.println("{" + this.dData + "}");
	}
}

class LinkList
{
	Link first;

	public LinkList()
	{
		this.first = null;
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public void insertFirst(long key)	//this method will be used in push()
	{
		Link newLink = new Link(key);
		if(this.isEmpty())	//if list is empty
		{
			first = newLink;
			newLink.next = null;
		}
		else
		{
			newLink.next = first;
			first = newLink;
		}
	}

	public long deleteFirst()		//this method will be used in pop();
	{
		Link current = null;
		if(this.isEmpty())
		{
			System.out.println("Your stack is empty");
			return -1;
		}
		else
		{
			current = first;
			first = first.next;
			return current.dData;
		}
	}

	public void displayList()
	{
		Link current = first;
		System.out.println("stack (top-->buttom): ");
		if(this.isEmpty())
		{
			System.out.println("Your list is empty, nothing to show!");
		}
		else
		{
			while(current!=null)
			{
				current.displayLink();
				current = current.next;
			}
			//System.out.println("");
		}
	}
}

class LinkStack
{
	LinkList list = new LinkList();
	public void push(long key)
	{
		list.insertFirst(key);
	}
	public long pop()
	{
		return list.deleteFirst();
	}
	public void showStack()
	{
		list.displayList();
	}
}

class LinkStackApp
{
	public static void main(String[] args)
	{
		LinkStack linkStack = new LinkStack();
		linkStack.push(20);	//push four element
		linkStack.push(40);

		linkStack.showStack();	//look what is in the stack

		linkStack.push(60);
		linkStack.push(80);

		linkStack.showStack();	//look what is in the stack

		linkStack.pop();
		linkStack.pop();

		linkStack.showStack();	//look what is in the stack
	}
}
