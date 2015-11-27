/*
 *Imagine a queue in front of you,your left side is the front of the queue,your right side is the rear of queue;
 *this seems more logical and close to real life
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
		System.out.print("{" + this.dData + "}");
	}
}

class FirstLastList
{
	Link first;
	Link last;

	public FirstLastList()
	{
		this.first = null;  //when create an object of LinkList,make sure it is empty!
		this.last = null;
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public void insertLast(long key)	//this method will be used when I create insert() method 
	{									//in Queue(not the class Queue,I just mean a Queue)
		Link newLink = new Link(key);
		if(this.isEmpty())				//if list is empty
		{
			first = newLink;			//draw a picture can help me understand it !
			last = newLink;
			newLink.next = null;
		}
		else
		{
			last.next = newLink;
			last = newLink;
			newLink.next = null;
		}
	}

	public long deleteFirst()		//this method will be used when I create remove() method in Queue(not the class Queue,I just mean a Queue)
	{
		Link current = null;
		if(this.isEmpty())
		{
			System.out.println("Your stack is empty");
			return -1;
		}
		else if(first==last)
			{
				current = first;
			    first = null;
			    last = null;
			    return current.dData;
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
		System.out.print("Queue (front-->rear): ");
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
			System.out.println("");
		}
	}
}

class LinkQueue
{
	FirstLastList list = new FirstLastList();	//two-ended list
	public void insert(long key)
	{
		list.insertLast(key);
	}
	public long remove()
	{
		return list.deleteFirst();
	}
	public void showQueue()
	{
		list.displayList();
	}
}

class LinkQueueApp
{
	public static void main(String[] args)
	{
		LinkQueue theQueue = new LinkQueue();
		theQueue.insert(12);	//insert four elements
		theQueue.insert(13);
		theQueue.insert(14);
		theQueue.insert(15);

		theQueue.showQueue();	//look at what is in the queue

		theQueue.remove();		//remove two elements ,from right side
		theQueue.remove();
		theQueue.showQueue();	//look at what is in the queue now!
	}
}
