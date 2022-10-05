using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment_02
{
    internal class Rectangle
    {
        private int length;
        private int width;
        public Rectangle()
        {
            this.width = 1;
            this.length = 1;
        }
        public Rectangle(int length, int width)
        {
            this.width = width;
            this.length = length;

        }
        public int GetCurrentLength()
        {
            return length;
        }

        public int SetNewLength(int length)
        {
            this.length = length;
            return length;
        }
        public int GetCurrentWidth()
        {
            return width;
        }
        public int SetNewWidth(int width)
        {
            this.width = width;
            return width;
        }
        public int GetPerimeter()
        {
            int perimeter = 0;
            perimeter = (length + width) * 2;
            return perimeter;
        }
        public int GetArea()
        {
            int Area = 0;
            Area = length * width;
            return Area;
        }

    }
}
