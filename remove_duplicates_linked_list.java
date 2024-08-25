void remove_duplicates(Node *root)
{
    if(root==NULL)
	retrun NULL;
    Node *curr=root;
    Node *q=NULL;
    while(curr!=NULL && curr->next!=NULL)
    {
	if(curr->data==curr->next->data)
	{
	    q=curr->next->next;
	    if(q==NULL)
	    {
		curr->next=NULL;
		break;
	    }
	    curr->next=q;
	}
	if(curr->data != curr->next->data)
	{
	    curr->curr->next;
	}
    }
}
