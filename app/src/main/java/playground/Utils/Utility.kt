package playground.Utils

class Utility
{
    companion object {

        fun validateForEmptyEditText(vararg strings:String):Boolean
        {
            var isEmpty = false
            for(string in strings)
            {
                if(string.isEmpty())
                {
                    isEmpty = true
                }
            }
            return isEmpty
        }
    }
}
