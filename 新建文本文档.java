 for (int i = 0; i < devicenamelist.Count; i++)
            {
                if (name.Equals(devicenamelist[i]))
                {
                    return;
                    
                }else if (i == devicenamelist.Count - 1 )
                {
                    devicenamelist.Add(name);
                    adddatatolistview(name);
                }
            }