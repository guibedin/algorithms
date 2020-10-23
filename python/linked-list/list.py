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

    def add_node(self, node):
        """
        Add a node at the start of the list

        Parameters
        ----------
        node : ListNode
        """
        node.next = self.head
        self.head = node
        self.size += 1
    
    def remove_node(self, value):
        """
        Removes the node passed by parameter.
        If node was found, return node.value.
        If node is not found, return None.
        
        Parameters
        ----------
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
            
    def print_list(self):
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
        my_list.add_node(ListNode(i))
    
    my_list.print_list()
    
    # Remove middle element
    my_list.remove_node(5)
    
    # Remove first element
    my_list.remove_node(9)
    
    # Remove last element
    my_list.remove_node(0)

    # Try to remove non-existing element
    my_list.remove_node(10)

    my_list.print_list()

main()