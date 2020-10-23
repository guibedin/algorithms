class ListNode:
    """Node of a linked list"""

    def __init__(self, value):
        """
        Parameters
        value : int
        """
        self.value = value
        self.next = None

class List:
    """Linked list"""
    def __init__(self):
        """Creates an empty list with head = None"""

        self.head = None
        self.size = 0

    def addNode(self, node):
        """
        Add a node at the start of the list
        Parameters
        node : ListNode
        """
        node.next = self.head
        self.head = node
        self.size += 1
    
    def removeNode(self, value):
        """
        Removes the node passed by parameter.
        If node was found, return node.value.
        If node is not found, return None.
        
        Parameters
        node : ListNode
        """
        tmp = self.head
        # Node to be removed is the first one?
        if value == tmp.value:
            self.head = tmp.next
            self.size -= 1
            return tmp.value
        
        # Search for node in list
        while tmp != None:
            tmp2 = tmp.next
            if tmp2 != None:
                # Found node - Before node.next = tmp2.next
                if value == tmp2.value:
                    tmp.next = tmp2.next
                    self.size -= 1
                    return tmp2.value
                tmp2 = tmp2.next
            tmp = tmp.next
        
        # Node not found
        return None
            
    def printList(self):
        """
        Prints the list in current order.
        """

        tmp = self.head
        print(f"List size: {self.size}")
        print("[", end="")
        while tmp.next != None:
            print(f"{tmp.value}, ", end="")
            tmp = tmp.next
        
        print(f"{tmp.value}]")

def main():
    my_list = List()

    # Add 10 elements to list
    for i in range(10):
        my_list.addNode(ListNode(i))
    
    my_list.printList()
    # Remove middle element
    my_list.removeNode(5)
    # Remove first element
    my_list.removeNode(9)
    # Remove last element
    my_list.removeNode(0)
    # Remove non-existing element
    my_list.removeNode(10)

    my_list.printList()

main()